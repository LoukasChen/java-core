package com.csp.concurrency.thread;

import java.util.concurrent.TimeUnit;

/**
 * @desc: Sleep 可以让线程的运行状态由RUNNABLE->TIMED_WAITING
 * @author: csp52872
 * @date: 2021/10/17
 */
public class SleepAPI {

    public static void main(String[] args) throws InterruptedException {
        sleep();
        sleepThenInterrupt();
    }

    private static void sleep() throws InterruptedException {
        Thread thread1 = new Thread("t1") {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        System.out.println("thread1线程状态：" + thread1.getState());// NEW
        thread1.start();
        System.out.println("thread1线程状态：" + thread1.getState());// RUNNABLE

        TimeUnit.SECONDS.sleep(1);
        System.out.println("thread1线程状态：" + thread1.getState());// TIMED_WAITING
    }

    /**
     * 睡眠线程中断
     * @throws InterruptedException
     */
    private static void sleepThenInterrupt() throws InterruptedException {
        Thread thread2 = new Thread("t2") {
            @Override
            public void run() {
                try {
                    System.out.println("sleep thread");
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    System.out.println("interrupt thread");
                    e.printStackTrace();
                }
            }
        };

        thread2.start();
        TimeUnit.SECONDS.sleep(1);
        thread2.interrupt();
    }

}
