package com.csp.designPatterns.observer.original;

/**
 * @author csp
 * @description: TODO
 * @date 2019/8/26 22:58
 */
public class SimpleObserver1 implements Observer {

    private final Subject subject;

    public SimpleObserver1(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String name, Integer age) {
        System.out.println(this.getClass().getSimpleName() + "-> update name:" + name + ",age:" + age);
    }
}
