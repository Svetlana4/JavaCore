package lesson7.project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson7.project.entity.Weather;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccuweatherModel implements WeatherModel{
//    http://dataservice.accuweather.com/forecasts/v1/daily/1day/
//    http://dataservice.accuweather.com/forecasts/v1/daily/5day/

    private static final String PROTOCOL = "http";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAYS = "5day";
    private static final String API_KEY = "7RK4AYTfSGyrovnw5EYBBNoPAVZtAI4H";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient= new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private DatadaseRepository datadaseRepository = new DatadaseRepository();


    @Override
    public void getWeather(String selectedCity, Period period) throws IOException {
        switch (period){
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();


                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecasResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecasResponse.body().string();
//                System.out.println(weatherResponse);

                Weather weather = parseWeatherResponse(selectedCity, weatherResponse, 0);
//                System.out.println(weather);

                datadaseRepository.saveWeatherToDatabase(weather);

                break;



            case FIVE_DAYS:
                HttpUrl httpUrl1 = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYS)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request1 = new Request.Builder()
                        .url(httpUrl1)
                        .build();

                Response fiveDayForecasResponse = okHttpClient.newCall(request1).execute();
                String weatherResponse1 = fiveDayForecasResponse.body().string();
//                System.out.println(weatherResponse1);

                List<Weather> weatherList = new ArrayList<>();


                for (int i = 0; i < 5; i++) {
                    Weather w = parseWeatherResponse(selectedCity, weatherResponse1, i);
                    weatherList.add(w);
                }
                datadaseRepository.saveWeatherToDatabase(weatherList);

                break;
        }
    }

    private String detectCityKey(String selectedCity) throws IOException {
//        http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response cityResponse = okHttpClient.newCall(request).execute();
        String weatherResponse = cityResponse.body().string();
//        System.out.println(weatherResponse);

        String cityKey = objectMapper.readTree(weatherResponse).get(0).at("/Key").asText();

//        System.out.println(cityKey);

        return cityKey;
    }

    @Override
    public List<Weather> getSavedToDBWeather() {
        return datadaseRepository.getSavedToDBWeather();

    }

    public static void main(String[] args) throws IOException {

        //WeatherResponse weatherResponse = parseWeatherResponse("Piter", response);
        //System.out.println(weatherResponse);

//        AccuweatherModel accuweatherModel = new AccuweatherModel();
////        accuweatherModel.detectCityKey("Moscow");
//        accuweatherModel.getWeather("Moscow", Period.NOW);

        UserInterfaceView userInterfaceView = new UserInterfaceView();
        userInterfaceView.runInterface();


    }

    @NotNull
    private static Weather parseWeatherResponse(String city, String response, int day) throws JsonProcessingException {
        String date = objectMapper.readTree(response).get("DailyForecasts").get(day).get("Date").asText();

        JsonNode temperatureBlock = objectMapper.readTree(response).get("DailyForecasts").get(day).get("Temperature").get("Minimum");
        double temperatureNumber = temperatureBlock.get("Value").asDouble();
        String temperatureUnit = temperatureBlock.get("Unit").asText();

        JsonNode weatherDayBlock = objectMapper.readTree(response).get("DailyForecasts").get(day).get("Day");



        boolean hasPrecipitation = weatherDayBlock.get("HasPrecipitation").asBoolean();
        String weatherText;

        if(hasPrecipitation == true){
            String weatherDayType = weatherDayBlock.get("PrecipitationType").asText();
            String weatherDayIntensity = weatherDayBlock.get("PrecipitationIntensity").asText();

            weatherText = weatherDayType + ", " + weatherDayIntensity;
        } else {
            weatherText = "sunny";
        }

        return new Weather(city, date, temperatureNumber);
    }
}
