package com.csp.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @desc: 类型擦除
 * @author: csp52872
 * @date: 2021/01/17
 */
public class TypeErasure {

    public static void main(String[] args) {
        assign();
    }

    /**
     * 通过赋值操作擦除泛型
     */
    private static void assign() {
        List<String> list = new ArrayList<>();
        list.add("c1");

        Collection typeErasure = list;
        typeErasure.add(1);
        System.out.println(list);
    }

    /**
     * 通过反射修改泛型类型
     */
    private static void reflect() {
        List<String> list = new ArrayList<>();
        list.add("c1");

        list.getClass();
    }
}
