package com.csp.java8.lambda.FactoryPattern;

/**
 * @description: 工厂模式
 * @author: csp52872
 * @date: 2021/03/28
 */
public class ProductFactory {

    public static Product createProduct(String name) {
        switch (name) {
            case "loan":
                return new Loan();
            case "stock":
                return new Stock();
            case "bond":
                return new Bond();
            default:
                throw new RuntimeException("No such product " + name);
        }
    }

}
