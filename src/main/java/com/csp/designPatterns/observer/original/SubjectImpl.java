package com.csp.designPatterns.observer.original;

import java.util.ArrayList;
import java.util.List;

/**
 * @author csp
 * @description: TODO
 * @date 2019/8/26 22:50
 */
public class SubjectImpl implements Subject {
    /**
     * 观察者集合
     */
    private final List<Observer> observers;

    private String name;

    private Integer age;

    public SubjectImpl() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.removeIf(ob -> ob.equals(observer));
    }

    @Override
    public void notifyObservers() {
        observers.forEach(ob -> ob.update(name, age));
    }

    public void setProps(String name, Integer age) {
        this.name = name;
        this.age = age;
        notifyObservers();
    }

}
