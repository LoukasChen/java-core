package com.csp.java8.lambda;

/**
 * @description:
 * @author: csp
 * @date: 2020/03/14
 */
@FunctionalInterface
public interface Test<T> {
    void eat(T t);

    default void get() {
        return;
    }

    static <T> Test<T> pull() {
        return null;
    }
}
