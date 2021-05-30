package com.csp.java8.lambda.strategyPattern;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/03/28
 */
public class IsNumeric implements ValidationStrategy {

    @Override
    public boolean execute(String params) {
        return params.matches("\\d+");
    }
}
