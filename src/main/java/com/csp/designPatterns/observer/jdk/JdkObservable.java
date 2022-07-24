package com.csp.designPatterns.observer.jdk;

import java.util.Observable;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/7/17
 */
public class JdkObservable extends Observable {

    private String name;

    private Integer age;

    private Observable observable;

    public void setProps(String name, Integer age) {
        this.name = name;
        this.age = age;
        setChanged();
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
