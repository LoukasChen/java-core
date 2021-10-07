package com.csp.reflect;

/**
 * @author: csp52872
 * @date: 2021/08/11
 */
public class Foo {

    private String foo = "foo";

    class Bar {

        private String bar = "bar";

        public void get() {
            System.out.println(foo);
        }
    }
}
