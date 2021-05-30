package com.csp.collection.list;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/03/13
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.add("java");
        deque.add("scala");
        deque.add("go");
        System.out.println(deque.peek());
    }

}
