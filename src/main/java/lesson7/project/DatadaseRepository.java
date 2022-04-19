package lesson7.project;

import lesson7.project.entity.Weather;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatadaseRepository {
    private String insertWeather = "insert into weather (city, localdate, temperature) values (?, ?, ?)";
    private String getWeather = "select * from weather";
    private static final String DB_PATH = "jdbc:sqlite:geekbrains.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean saveWeatherToDatabase(Weather weather) {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getLocalDate());
            saveWeather.setDouble(3, weather.getTemperature());

            return saveWeather.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveWeatherToDatabase(List<Weather> weatherList) {

        try(Connection connection = DriverManager.getConnection(DB_PATH)){
            connection.setAutoCommit(false);
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            for (Weather weather : weatherList) {
                saveWeather.setString(1, weather.getCity());
                saveWeather.setString(2, weather.getLocalDate());
                saveWeather.setDouble(3, weather.getTemperature());
                saveWeather.addBatch();
            }
            saveWeather.executeBatch();

            connection.commit();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public List<Weather> getSavedToDBWeather() {

        List<Weather> weatherList = new ArrayList<>();
//        нужно брать погоду селектиком , получится резалтсетБ его обрабатывать, и создавать объектик(уже делали когда парсили что нибудь,
//        ДЗ
        try {
            Connection connection = DriverManager.getConnection(DB_PATH);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getWeather);

            while (resultSet.next()){
                Weather weather = new Weather(resultSet.getString("city"),
                                             resultSet.getString("localdate"),
                                             resultSet.getDouble("temperature"));
                weatherList.add(weather);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return weatherList;

    }

}
