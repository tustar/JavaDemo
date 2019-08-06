package com.tustar.headfirst.designpatterns.observer;

public class WeatherStation {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay display = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 80, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
