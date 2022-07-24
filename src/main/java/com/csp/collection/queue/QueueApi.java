package com.csp.collection.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @description: 队列
 * @author: csp52872
 * @date: 2021/05/23
 */
public class QueueApi {

    private static final Queue queue = new ArrayDeque<>();

    static {
        queue.add("java");
        queue.add("scala");
        queue.add("groovy");
    }

    public static void main(String[] args) {
        addOrOffer();
    }

    /**
     * add/offer都是向队列尾部添加元素
     */
    private static void addOrOffer() {
        // 队列满时，add方法会抛异常
        System.out.println(queue.add("go"));
        // 队列满时，offer会返回false
        System.out.println(queue.offer("go"));
    }

    /**
     * 队列头部弹出（删除）第一个元素，然后返回被删除的元素
     */
    private static void removeOrPoll() {
        // 队列为空时，抛异常NoSuchElementException
        System.out.println(queue.remove());
        // 队列为空时，返回null
        System.out.println(queue.poll());
    }

    /**
     * 返回队列头部元素，不改变队列
     */
    private static void elementOrPeek() {
        // 队列为空时，抛异常NoSuchElementException
        System.out.println(queue.element());
        // 队列为空时，返回null
        System.out.println(queue.peek());
    }

}
