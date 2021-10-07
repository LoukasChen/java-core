package com.csp.jvm.imitate;

import java.util.concurrent.TimeUnit;

/**
 * @desc: 死锁
 * @author: csp52872
 * @date: 2021/10/6
 */
public class DeadLock {

    static Object o1 = new Object();

    static Object o2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        deadLock();
    }

    private static void deadLock() throws InterruptedException {

        new Thread(() -> {
            synchronized (o1) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("获得o1和o2的锁");
                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            synchronized (o2) {
                synchronized (o1) {
                    System.out.println("获得o2和o1的锁");
                }
            }
        }).start();
    }

}
