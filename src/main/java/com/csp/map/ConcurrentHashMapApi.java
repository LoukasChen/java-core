package com.csp.map;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/05/17
 */
public class ConcurrentHashMapApi {

    private static final ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    static {
        map.put("key1", 123);
        map.put("key2", 234);
        map.put("key3", 345);
    }

    public static void main(String[] args) {
        reduceValues();
        mappingCount();
    }

    private static void reduceValues() {
        Optional<Integer> maxValue = Optional.of(map.reduceValues(1, Integer::sum));
        System.out.println(maxValue.get());
    }

    private static void mappingCount() {
        // 等同于size，但是count返回的是long
        System.out.println(map.mappingCount());
    }

}
