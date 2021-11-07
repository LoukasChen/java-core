package com.csp.concurrency.thread;

import java.util.concurrent.TimeUnit;

/**
 * @desc: 活锁
 * @author: csp52872
 * @date: 2021/10/31
 */
public class ActiveLock {

    private static int count = 10;

    public static void main(String[] args) {
        new Thread(() -> {
            while (count < 20) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                System.out.println("count++:" + count);
            }
        }).start();


        new Thread(() -> {
            while (count > 0) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
                System.out.println("count--:" + count);
            }
        }).start();

    }

}
