package com.csp.concurrency.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @desc: 线程中断
 * @author: csp52872
 * @date: 2021/10/17
 */
public class InterruptAPI {

    public static void main(String[] args) throws InterruptedException {
        interrupt();
        sleepThenInterrupt();
        parkThenInterrupt();
        stopThread();
    }

    private static void interrupt() {
        Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "线程被中断");
                    break;
                }
            }
        }, "t1");
        thread.start();
        thread.interrupt();
    }

    private static void sleepThenInterrupt() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("sleep thread");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("interrupt thread");
                // sleep 中断异常抛出后，isInterrupted 为false
                e.printStackTrace();
            }
        }, "t1");

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        System.out.println("thread1 isInterrupted:" + thread.isInterrupted()); // false
    }

    private static void parkThenInterrupt() {
        Thread thread = new Thread(() -> {
            System.out.println("thread park");
            LockSupport.park();
            System.out.println("thread unPark");
            // Thread.currentThread().isInterrupted() 不会清楚中断标记，只做判断
            System.out.println("interrupt state:" + Thread.currentThread().isInterrupted());
            // Thread.currentThread().isInterrupted() 会清楚中断标记
            System.out.println("interrupt state:" + Thread.interrupted());

            LockSupport.park();
            System.out.println("thread re unPark");
        }, "park");
        thread.start();
        thread.interrupt();
    }

    private static void stopThread() throws InterruptedException {
        TwoPhaseTermination twoPhaseTermination = new TwoPhaseTermination();
        twoPhaseTermination.start();
        TimeUnit.SECONDS.sleep(1);
        twoPhaseTermination.stop();
    }

    /**
     * 两阶段终止线程
     */
    private static class TwoPhaseTermination {

        private Thread monitor;

        public void start() {
            monitor = new Thread(() -> {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println(Thread.currentThread().getName() + "线程被中断");
                        break;
                    }
                    try {
                        System.out.println("执行监控");
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }, "monitor");
            monitor.start();
        }

        public void stop() {
            monitor.interrupt();
        }

    }

}
