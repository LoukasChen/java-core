package com.csp.java8.lambda.strategyPattern;

/**
 * @author: csp52872
 * @date: 2021/03/28
 */
public class IsAllLowerCase implements ValidationStrategy {

    @Override
    public boolean execute(String params) {
        return params.matches("[a-z]+");
    }

}
