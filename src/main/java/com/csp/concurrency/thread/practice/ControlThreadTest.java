package com.csp.concurrency.thread.practice;

/**
 * @desc: 两个线程，要满足先打印2，后打印1
 *          此处使用wait/notify解法
 * @author: csp52872
 * @date: 2021/11/2
 */
public class ControlThreadTest {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (ControlThreadTest.class) {
                for (int i = 0; i < 10; i++) {
                    try {
                        ControlThreadTest.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1");
                    ControlThreadTest.class.notify();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            synchronized (ControlThreadTest.class) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("2");
                    ControlThreadTest.class.notify();
                    try {
                        ControlThreadTest.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread2.start();
    }
}
