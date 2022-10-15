package com.csp.designPattern.creation.factory;

/**
 * @author csp
 * @date 2022/7/28
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory();
        factory.createProductA().print();
        factory.createProductB().work();
    }
}
