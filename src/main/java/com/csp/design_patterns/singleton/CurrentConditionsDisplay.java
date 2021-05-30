package com.csp.design_patterns.singleton;

/**
 * @author csp
 * @description: TODO
 * @date 2019/8/26 22:58
 */
public class CurrentConditionsDisplay implements Observer,DisplayElement {

    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("当前温度："+temperature+"湿度："+humidity);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
