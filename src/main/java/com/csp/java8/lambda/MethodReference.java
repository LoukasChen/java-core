package com.csp.java8.lambda;

import java.util.Arrays;

/**
 * @description: 方法引用
 * @author: csp52872
 * @date: 2020/10/04
 */
public class MethodReference {
    public static void main(String[] args) {
        String[] arr = new String[]{"fds", "qwe", "Efb", "Yer", "nggf"};
        Arrays.sort(arr, MethodReference::compareToIgnoreCase);
//        System.out.println(Arrays.toString(arr));
        System.out.println(String.join(",", arr));
    }

    /**
     * 忽略字母大小写排序
     */
    private static int compareToIgnoreCase(String s1, String s2) {
        return s1.compareToIgnoreCase(s2);
    }
}
