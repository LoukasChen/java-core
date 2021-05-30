package com.csp.array;

import java.util.Arrays;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/05/16
 */
public class ArrayCopy {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        System.arraycopy(ints, 2, ints, 1, 3);
        ints[ints.length - 1] = null;
        System.out.println(Arrays.toString(ints));
    }
}
