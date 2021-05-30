package com.csp.collection.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author csp
 * @description: List去重
 * @date 2019/9/13 13:57
 */
public class DistinctArrayList {

    private static final List<String> list = new ArrayList<>();

    static {
        list.add("规范");
        list.add("java");
        list.add("scala");
        list.add("java");
    }

    public static void main(String[] args) {
        streamDistinct();
    }

    /**
     * 重新复制到另外一个集合
     */
    private static void copyNewList() {
        List<String> newList = new ArrayList<>();
        for (String arrayList : list) {
            if (!newList.contains(arrayList)) {
                newList.add(arrayList);
            }
        }
        System.out.println(newList);
    }

    /**
     * 利用hashset去重(有序)
     */
    private static void setDistinctOrder() {
        Set<String> hashSet = new HashSet<>();
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            if (hashSet.add(s)) {
                newList.add(s);
            }
        }
        System.out.println(newList);
    }

    /**
     * 利用hashset去重(无序)
     */
    private static void setDistinctDisOrder() {
        Set<String> set = new HashSet<>(list);
        System.out.println(new ArrayList<>(set));
    }

    /**
     * java8Stream的distinct
     */
    private static void streamDistinct() {
        List<String> newList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(newList);
    }
}
