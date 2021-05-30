package com.csp.java8.lambda.strategyPattern;

/**
 * @description: 策略模式
 * @author: csp52872
 * @date: 2021/03/28
 */
public interface ValidationStrategy {

    boolean execute(String params);
}
