package com.csp.java8.lambda.FactoryPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author: csp52872
 * @date: 2021/03/28
 */
public class GetProduct {

    private static final Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static void main(String[] args) {

//        Product loan = ProductFactory.createProduct("loan");

        Product loan = GetProduct.createProduct("loan");
    }

    public static Product createProduct(String name) {
        Supplier<Product> supplier = map.get(name);
        if (supplier != null) {
            return supplier.get();
        }
        throw new IllegalArgumentException("No such product " + name);
    }
}
