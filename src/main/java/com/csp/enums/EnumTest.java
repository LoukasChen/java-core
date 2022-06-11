package com.csp.enums;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/12/12
 */
public enum EnumTest {

    A("a") {

        @Override
        public void run() {
            System.out.println("Enum inner class run");
        }

    };

    private String name;

    EnumTest(String name) {
        this.name = name;
    }

    public abstract void run();

}

