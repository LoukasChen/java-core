package com.csp.designPatterns.factory;

/**
 * @author csp
 * @date 2022/7/28
 */
public class ConcreteProductB implements AbstractProductB {

    public ConcreteProductB() {
        System.out.println("ConcreteProductB init...");
    }

    @Override
    public void work() {
        System.out.println("ConcreteProductB work...");
    }
}
