package com.csp.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author csp
 * @description: TODO
 * @date 2019/9/13 21:36
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> synchronizedMap = Collections.synchronizedMap(map);
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 12; i++) {
            map.put("java" + i, i);
        }
        for (int i = 0; i < 12; i++) {
            map.put("scala" + i, i);
        }

    }
}
