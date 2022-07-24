package com.csp.collection.queue;

import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;

/**
 * @desc: 利用优先队列 实现 TopK 元素
 * @author: csp52872
 * @date: 2022/7/17
 */
public class TopK<E> {

    private int k;

    private PriorityQueue<E> priorityQueue;

    public TopK(int k) {
        this.k = k;
        this.priorityQueue = new PriorityQueue<>();
    }

    public void addAll(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return;
        }
        collection.forEach(this::add);
    }

    public void add(E e) {
        if (priorityQueue.size() < k) {
            priorityQueue.offer(e);
            return;
        }
        Comparable<? super E> head = (Comparable<? super E>) priorityQueue.peek();
        if (head.compareTo(e) > 0) {
            return;
        }
        priorityQueue.poll();
        priorityQueue.offer(e);
    }

    public <T> T[] toArray(T[] arr) {
        return priorityQueue.toArray(arr);
    }

    public E getKth() {
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        TopK<Object> topK = new TopK<>(5);
        topK.addAll(Arrays.asList(12, 34, 56, 3, 1, 67, 43, 78));
        System.out.println(Arrays.toString(topK.toArray(new Integer[0])));
        System.out.println(topK.getKth());
    }

}
