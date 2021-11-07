package com.csp.concurrency.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/11/6
 */
public class AtomicIntegerArrayApi {

    private AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);

    public static void main(String[] args) {
        AtomicIntegerArrayApi api = new AtomicIntegerArrayApi();
        System.out.println(api.addAndGet());
    }

    private int addAndGet() {
        return this.atomicIntegerArray.addAndGet(0, 50);
    }
}
