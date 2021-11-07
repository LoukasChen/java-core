package com.csp.concurrency.lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: Lock
 * @author: csp52872
 * @date: 2021/05/22
 */
public class ReentrantLockTest {

    // 默认和sychronized为非公平锁
    private static final Lock unfairLock = new ReentrantLock();

    // 参数传递true为公平锁，相比较更消耗cpu性能
    private static final Lock fairLock = new ReentrantLock(true);

    private static final Lock myLock = new MyLock();

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new LoopLock());
//        Thread thread1 = new Thread(new LoopSync());
        Thread thread2 = new Thread(new LoopLock());
//        Thread thread2 = new Thread(new LoopSync());
        thread1.start();
        thread2.start();
//        thread1.join();
//        thread2.join();
    }

    static class LoopLock implements Runnable {

        @Override
        public void run() {
            unfairLock.lock();
//            myLock.lock();
            try {
                while (count < 20) {
                    count++;
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                }
            } finally {
                count = 0;
                unfairLock.unlock();
//                myLock.unlock();
            }
        }
    }

    static class LoopSync implements Runnable {

        @Override
        public void run() {
            synchronized (LoopSync.class) {
                while (count < 20) {
                    count++;
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                }
            }
        }
    }

}
