package com.csp.concurrency.lock.practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @desc: 两个线程，要满足先打印2，后打印1
 * 此处使用ReentrantLock解法
 * @author: csp52872
 * @date: 2021/11/2
 */
public class ControlThreadLockTest {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread thread1 = new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1");
                    condition.signal();
                }
            } finally {
                lock.unlock();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.println("2");
                    condition.signal();
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        });
        thread2.start();
    }

}
