package com.csp.designPattern.behavior.observer.original;

/**
 * @desc: 测试观察者
 * @author: csp52872
 * @date: 2022/7/16
 */
public class SimpleObserver2 implements Observer {

    private final Subject subject;

    public SimpleObserver2(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String name, Integer age) {
        System.out.println(this.getClass().getSimpleName() + "-> update name:" + name + ",age:" + age);
    }

}
