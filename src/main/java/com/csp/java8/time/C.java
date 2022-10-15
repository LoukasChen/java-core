package com.csp.java8.time;

/**
 * @author csp
 * @date 2022/10/4
 */
public interface C extends A {

    @Override
    default void hello() {
        System.out.println("Hello from C");
    }
}
