package com.csp.java8.lambda.templateMethod;

/**
 * @author: csp52872
 * @date: 2021/03/28
 */
public class OnlineBankingCustomer extends OnlineBanking {

    @Override
    void makeCustomerHappy(Customer customer) {
        System.out.println(customer.getId());
    }

    public static void main(String[] args) {
        new OnlineBankingCustomer().processCustomer(1);
    }

}
