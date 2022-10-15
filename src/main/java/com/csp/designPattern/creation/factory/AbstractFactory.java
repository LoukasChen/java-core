package com.csp.designPattern.creation.factory;

/**
 * @desc 抽象工厂模式
 * @author csp
 * @date 2022/7/28
 */
public interface AbstractFactory {

    AbstractProductA createProductA();

    AbstractProductB createProductB();
}
