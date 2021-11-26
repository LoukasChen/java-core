package com.csp.string;

import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/03/21
 */
public class StringJoinerApi {
    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        IntStream.range(1, 10).forEach(i -> stringJoiner.add(i + ""));
        System.out.println(stringJoiner);
    }
}
