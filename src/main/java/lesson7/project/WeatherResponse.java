package lesson7.project;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public class WeatherResponse {

//    List<OneDayResponse> days;
    private String city;
    private String date;
    private String temperature;
    private String weatherText;

    public WeatherResponse(String city, String date, String temperature, String weatherText) {
        this.date = date;
        this.temperature = temperature;
        this.city = city;
        this.weatherText = weatherText;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    @Override
    public String toString() {
        return "weather in " + city +
                " :  date = " + date +
                ", temperature = " + temperature +
                ", precipitation = " + weatherText;
    }

}
