package com.csp.designPatterns.singleton;

/**
 * @author csp
 * @description: TODO
 * @date 2019/8/26 23:02
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,70,29.2f);
        weatherData.setMeasurements(78,90,30.8f);
    }
}
