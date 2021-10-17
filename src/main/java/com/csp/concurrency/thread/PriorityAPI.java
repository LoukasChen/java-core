package com.csp.concurrency.thread;

/**
 * @desc: 设置线程优先级
 * @author: csp52872
 * @date: 2021/10/17
 */
public class PriorityAPI {

    public static void main(String[] args) {
        setPriority();
    }

    private static void setPriority() {
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
                    System.out.println("thread2 run count=" + count++);
                }
            }
        };

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
    }
}
