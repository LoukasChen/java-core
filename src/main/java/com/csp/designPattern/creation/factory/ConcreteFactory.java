package com.csp.designPattern.creation.factory;

/**
 * @desc 具体工厂类
 * @author csp
 * @date 2022/7/28
 */
public class ConcreteFactory implements AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB();
    }
}
