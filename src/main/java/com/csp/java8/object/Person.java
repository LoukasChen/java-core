package com.csp.java8.object;

import java.util.Optional;

/**
 * @author: csp52872
 * @date: 2021/02/10
 */
public class Person {

    private String name;

    private Integer age;

    private Car car;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Optional<Car> getCar() {
        return Optional.ofNullable(car);
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
