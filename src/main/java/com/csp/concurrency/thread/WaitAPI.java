package com.csp.concurrency.thread;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/10/31
 */
public class WaitAPI {

    private static final Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (obj) {
                try {
                    System.out.println("t1 into synchronized");
                    obj.wait();
                    System.out.println("t1 wake");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (obj) {
                try {
                    System.out.println("t2 into synchronized");
                    obj.wait();
                    System.out.println("t2 wake");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();

        // 主线获得锁
        synchronized (obj) {
            System.out.println("main thread notifyAll");
            obj.notifyAll();
        }

    }
}
