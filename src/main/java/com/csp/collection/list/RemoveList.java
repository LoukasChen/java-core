package com.csp.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: List删除的几种方式
 * @author: csp
 * @date: 2020/04/05
 */
public class RemoveList {
    public static void main(String[] args) {
        List<Integer> list = Stream.generate(() -> new Random().nextInt()).limit(10).collect(Collectors.toList());
        System.out.println(iterRemoveList(list));
    }

    /**
     * 迭代器删除元素，删除原集合
     */
    private static List<Integer> iterRemoveList(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        if (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        return list;
    }

    /**
     * 降序删除集合，删除原集合
     */
    private static List<Integer> descRemoveList(List<Integer> list) {
        for (int i = list.size() - 1; i > 10; i--) {
            list.remove(i);
        }
        return list;
    }

    /**
     * 使用stream的filter过滤元素，不修改原集合
     */
    private static List<Integer> filterList(List<Integer> list) {
        return list.stream().filter(it -> it > 0).collect(Collectors.toList());
    }

    /**
     * java8提供的removeIf方法，修改原集合
     */
    private static List<Integer> removeIfList(List<Integer> list) {
        return list.removeIf(it -> it > 0) ? list : new ArrayList<>();
    }

}
