package com.csp.java8.lambda.templateMethod;

import java.util.function.Consumer;

/**
 * @description: 利用Lambda表达式优化模板方法
 * @author: csp52872
 * @date: 2021/03/28
 */
public class OnlineBankingLambda {

    public void processCustomer(int id, Consumer<Customer> consumer) {
        Customer customer = new Customer(id);
        consumer.accept(customer);
    }

    public static void main(String[] args) {
        new OnlineBankingLambda().processCustomer(1, customer -> System.out.println(customer.getId()));
    }
}
