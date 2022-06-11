package com.csp.enums;

/**
 * @description:
 * @author: csp52872
 * @date: 2020/11/22
 */
public enum EnumDemo implements EnumInte {
    DESC("desc"),SMALL("small");

    private String desc;

    EnumDemo(String desc) {
        this.desc = desc;
    }

    @Override
    public void test(String str) {
        print();
    }

    public static void main(String[] args) {
        EnumDemo enumDemo = EnumDemo.DESC;
        switch (enumDemo) {
            case DESC:
                break;
            case SMALL:
                //
                break;
        }
    }
}
