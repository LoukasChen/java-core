package com.csp.collection.queue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @description: 双端队列
 * @author: csp52872
 * @date: 2021/05/23
 */
public class DequeApi {

    private static final Deque<String> deque = new LinkedList<>();

    static {
        deque.add("java");
        deque.add("scala");
        deque.add("groovy");
    }

    public static void main(String[] args) {
        push();
        pop();
        peek();
        addFirstOrLast();
        getFirstOrLast();
        removeFirstOrLast();
        descendingIterator();
    }

    /**
     * push表示入栈，在栈顶添加元素
     * 如果栈满了，会抛异常
     */
    private static void push() {
        deque.push("go");
        System.out.println(deque);
    }

    /**
     * pop表示从栈顶弹出元素，
     * 如果栈为空，会抛异常
     */
    private static void pop() {
        System.out.println(deque.pop());
    }

    /**
     * peek查看栈头部元素，不修改栈
     */
    private static void peek() {
        System.out.println(deque.peek());
    }

    /**
     * 头部、尾部添加数据
     */
    private static void addFirstOrLast() {
        // add头尾添加数据，在容量不够的情况下会抛异常
        deque.addFirst("addFirst");
        deque.addLast("addLast");
        System.out.println(deque);


        // offer默认添加到尾部
        deque.offer("offer");
        // offer头尾添加数据，在容量不够的情况下返回null
        deque.offerFirst("offerFirst");
        deque.offerLast("offerLast");
        System.out.println(deque);
    }

    /**
     * 获取头部、尾部数据
     */
    private static void getFirstOrLast() {
        // get头尾获取数据，在队列为空的情况下会抛异常
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());

        // 取队头元素
        System.out.println(deque.peek());
        // peek头尾获取数据，在队列为空的情况下会返回null
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
    }

    /**
     * 删除头部、尾部元素
     */
    private static void removeFirstOrLast() {
        // remove头尾获取数据，在队列为空的情况下会抛异常
        deque.remove();
        deque.removeFirst();
        deque.removeLast();
        System.out.println(deque);

        // poll头尾删除数据，在队列为空的情况下会返回null
        deque.poll();
        deque.pollFirst();
        deque.pollLast();
        System.out.println(deque);
    }

    /**
     * 从尾到头遍历
     */
    private static void descendingIterator() {
        Iterator<String> iterator = deque.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
