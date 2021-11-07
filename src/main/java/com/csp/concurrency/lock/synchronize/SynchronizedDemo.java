package com.csp.concurrency.lock.synchronize;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/10/24
 */
public class SynchronizedDemo {

    public synchronized void get() throws InterruptedException {
        Object.class.notify();
        System.out.println("synchronized");
    }
}
