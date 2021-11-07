package com.csp.concurrency.lock.practice;

import java.util.concurrent.locks.LockSupport;

/**
 * @desc: 两个线程，要满足先打印2，后打印1
 * 利用park/unpark
 * @author: csp52872
 * @date: 2021/11/2
 */
public class ControlThreadRunTest {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            LockSupport.park();
            System.out.println("1");
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            System.out.println("2");
            LockSupport.unpark(thread1);
        });
        thread2.start();
    }
}
