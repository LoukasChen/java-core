package com.csp.collection.list;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: List常用方法
 * @author: csp52872
 * @date: 2021/05/16
 */
public class ListApi {
    public static void main(String[] args) {
        retainAll();
        replaceAll();
    }

    /**
     * 集合取交集
     */
    public static void retainAll() {
        List<String> arrayList1 = Stream.of("1", "2", "3").collect(Collectors.toList());
        List<String> arrayList2 = Stream.of("2", "3", "4").collect(Collectors.toList());

        arrayList1.retainAll(arrayList2);
        System.out.println(arrayList1); // [2,3]
    }

    /**
     * 对集合元素进行替换
     */
    public static void replaceAll() {
        List<String> list = Stream.of("a", "b", "c").collect(Collectors.toList());
        list.replaceAll(it -> it.toUpperCase());
        System.out.println(list); // [2,3]
    }
}
