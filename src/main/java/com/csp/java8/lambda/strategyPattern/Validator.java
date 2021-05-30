package com.csp.java8.lambda.strategyPattern;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/03/28
 */
public class Validator {
    private final ValidationStrategy validationStrategy;

    public Validator(ValidationStrategy validationStrategy) {
        this.validationStrategy = validationStrategy;
    }

    public boolean validate(String params) {
        return validationStrategy.execute(params);
    }

    public static void main(String[] args) {
        // 原生方式执行策略模式
        Validator validator = new Validator(new IsAllLowerCase());
        System.out.println(validator.validate("aaa"));

        Validator validator1 = new Validator(new IsNumeric());
        System.out.println(validator1.validate("bbb"));

        // lambda表达式改写策略模式
        Validator isAllLowerCase = new Validator(params -> params.matches("[a-z]+"));
        System.out.println(isAllLowerCase.validate("aaa"));

        Validator isNumeric = new Validator(params -> params.matches("\\d+"));
        System.out.println(isNumeric.validate("bbb"));
    }

}
