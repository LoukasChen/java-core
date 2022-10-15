package com.csp.designPattern.behavior.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/7/17
 */
public class JdkObserver1 implements Observer {

    private final Observable observable;

    public JdkObserver1(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof JdkObservable) {
            JdkObservable jdkObservable = (JdkObservable) o;
            String name = jdkObservable.getName();
            Integer age = jdkObservable.getAge();
            System.out.println(this.getClass().getSimpleName() + "-> update name:" + name + ",age:" + age);
        }
    }

}
