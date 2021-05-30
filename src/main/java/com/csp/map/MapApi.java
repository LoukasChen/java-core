package com.csp.map;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: Map在JDK1.8新增的常用API
 * @author: csp52872
 * @date: 2021/05/16
 */
public class MapApi {

    private static final Map<String, Integer> map;

    static {
        map = new HashMap() {
            {
                put("b", 51);
                put("c", 34);
                put("a", 45);
            }
        };

    }

    public static void main(String[] args) {
        putIfAbsent();
        System.out.println("=================");
        getOrDefault();
        System.out.println("=================");
        comparingByKeyOrValue();
        System.out.println("=================");
        computeIfAbsent();
        System.out.println("=================");
        computeIfPresent();
        System.out.println("=================");
        compute();
        System.out.println("=================");
        merge();
        System.out.println("=================");
        remove();
        System.out.println("=================");
        removeIf();
        System.out.println("=================");
        replaceAll();
    }

    /**
     * 如果map中的这个key已经存在，则直接取这个key对应的value；
     * 如果不存在，则put进去
     */
    private static void putIfAbsent() {
        map.putIfAbsent("a", 12);
        System.out.println(map.get("a"));

        map.putIfAbsent("d", 23);
        System.out.println(map.get("d"));
    }

    private static void getOrDefault() {
        System.out.println(map.getOrDefault("a", 213));
        System.out.println(map.getOrDefault("key", 123));
    }

    /**
     * 根据键或值对map排序
     */
    private static void comparingByKeyOrValue() {
        // comparingByKey根据键排序
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(System.out::println);
        // comparingByValue根据值排序
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(System.out::println);
    }

    /**
     * 类似写缓存操作
     * 1.先判断key是否有数据
     * 2.如果没有，则将key和value写入map
     */
    private static void computeIfAbsent() {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.computeIfAbsent("compute", cache -> cache.concat("absent")));
    }

    /**
     * 1.如果key的值为空，则返回null
     * 2.key不为null,计算传入的值
     */
    private static void computeIfPresent() {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.computeIfPresent("compute", (k, v) -> k.concat("present")));
        map.put("compute", "value");
        System.out.println(map.computeIfPresent("compute", (k, v) -> k.concat("present")));
    }

    private static void compute() {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.compute("compute", (k, v) -> (v == null) ? "empty" : v.concat("empty")));
    }

    /**
     * map合并value
     */
    private static void merge() {
        Map<String, String> map = new HashMap<>();
        map.put("merge", "test");
        System.out.println(map.merge("merge", "value", String::concat));
    }

    private static void remove() {
        Map<String, String> map = new HashMap<>();
        map.put("merge", "test");
        map.put("key", "test");
        map.remove("merge", "test");
        System.out.println(map);
    }

    /**
     * 根据条件删除
     */
    private static void removeIf() {
        map.entrySet().removeIf(it -> it.getValue() > 40);
        System.out.println(map);
    }

    /**
     * map的key/value替换
     */
    private static void replaceAll() {
        Map<String, String> map = new HashMap<>();
        map.put("merge", "test");
        map.replaceAll((k, v) -> v.toUpperCase());
        System.out.println(map);
    }

}
