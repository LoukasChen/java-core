package com.csp.array;

import java.util.Arrays;
import java.util.List;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/5/4
 */
public class ArraysList {

    public static void main(String[] args) {
        // 返回的是Arrays的内部类 ArrayList 无法进行增删操作
        List<Integer> integers = Arrays.asList(new Integer[]{1, 2});
//        integers.add(1); .UnsupportedOperationException



    }
}
