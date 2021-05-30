package com.csp.collection.list;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author csp
 * @description: TODO
 * @date 2019/9/29 17:32
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("规范");
        set.add("让我去");
        set.add("很过分");
        System.out.println(set);

        final List<String> list = new ArrayList<>();
        list.add("123");
        list.removeIf(i -> "123".equals(i));
        System.out.println(list);
        List<String> synchronizedList = Collections.synchronizedList(list);
        synchronizedList.add("");
        Object[] objects = list.toArray();
        Arrays.asList();
        Queue queue = new LinkedBlockingDeque();
        queue.add("gfa");
        queue.add("wer");
        queue.poll();
        queue.remove();

        list.add("规范");
        list.add("规范rew");
        list.add("规范few");
        List<String> list1 = Collections.unmodifiableList(list);
        list1.add("gf");
    }
}