package com.csp.designPatterns.observer.original;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/7/16
 */
public class SubjectObserverTest {

    public static void main(String[] args) {
        SubjectImpl subject = new SubjectImpl();
        new SimpleObserver1(subject);
        new SimpleObserver2(subject);
        subject.setProps("csp", 18);
    }
}
