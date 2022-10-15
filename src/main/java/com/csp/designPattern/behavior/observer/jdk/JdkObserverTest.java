package com.csp.designPattern.behavior.observer.jdk;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/7/17
 */
public class JdkObserverTest {

    public static void main(String[] args) {
        JdkObservable observable = new JdkObservable();
        new JdkObserver1(observable);
        observable.setProps("csp", 123);
    }

}
