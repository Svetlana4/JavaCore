package lesson6.socketexamples.hw6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Weather {
    public static void main(String[] args) throws IOException {

        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("/forecasts/v1/daily/1day/295212")
                .addQueryParameter("apikey", "7RK4AYTfSGyrovnw5EYBBNoPAVZtAI4H")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute();

        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(response.body().string());

    }

}
