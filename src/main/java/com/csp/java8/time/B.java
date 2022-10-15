package com.csp.java8.time;

/**
 * @author csp
 * @date 2022/10/4
 */
public interface B extends A {

    default void hello() {
        System.out.println("Hello from B");
    }
}
