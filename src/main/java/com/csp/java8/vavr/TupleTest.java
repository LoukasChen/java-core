package com.csp.java8.vavr;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.collection.Map;

/**
 * @description: 元组
 * @author: csp52872
 * @date: 2021/01/15
 */
public class TupleTest {

    public static void main(String[] args) {
        Tuple2<String, Integer> tuple2 = Tuple.of("java", 8);

        Map<Integer, List<Integer>> tuple2s = List.of(1, 2, 3, 4).groupBy(i -> i % 2);

        System.out.println();
    }

}
