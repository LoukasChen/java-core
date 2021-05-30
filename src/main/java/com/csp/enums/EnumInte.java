package com.csp.enums;

/**
 * @author: csp52872
 * @date: 2020/11/22
 */
public interface EnumInte {

    default void print() {
        System.out.println("EnumInte print");
    }

    void test(String str);
}
