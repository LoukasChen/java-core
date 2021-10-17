package com.csp.concurrency.thread;

/**
 * @desc: yield会让当前线程状态从Running->Runnable,然后cpu调度其他线程
 * @author: csp52872
 * @date: 2021/10/17
 */
public class YieldAPI {

    public static void main(String[] args) {
        yield();
    }

    private static void yield() {
        Thread thread1 = new Thread("t1") {
            @Override
            public void run() {
                int count = 0;
                while (true) {
                    System.out.println("thread1 run count=" + count++);
                }
            }
        };

        Thread thread2 = new Thread("t2") {
            @Override
            public void run() {
                int count = 0;
                while (true) {
                    Thread.yield();
                    System.out.println("thread2 run count=" + count++);
                }
            }
        };

        thread1.start();
        thread2.start();
    }
}
