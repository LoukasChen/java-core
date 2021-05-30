package com.csp.java8.lambda.templateMethod;

/**
 * @description: 模板方法
 * @author: csp52872
 * @date: 2021/03/28
 */
public abstract class OnlineBanking {

    public void processCustomer(int id) {
        Customer customer = new Customer(id);
        makeCustomerHappy(customer);
    }

    abstract void makeCustomerHappy(Customer customer);

}
