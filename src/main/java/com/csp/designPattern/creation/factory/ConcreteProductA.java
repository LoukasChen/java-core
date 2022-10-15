package com.csp.designPattern.creation.factory;

/**
 * @author csp
 * @date 2022/7/28
 */
public class ConcreteProductA implements AbstractProductA {

    public ConcreteProductA() {
        System.out.println("ConcreteProductA init...");
    }

    @Override
    public void print() {
        System.out.println("ConcreteProductA print...");
    }
}
