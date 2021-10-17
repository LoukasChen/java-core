package com.csp.concurrency.thread;

import java.util.concurrent.TimeUnit;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/10/17
 */
public class ThreadState {

    public static void main(String[] args) throws InterruptedException {
        newState();
        runnableState();
        blockedState();
        waitingState();
        timedWaitingState();
        terminatedState();
    }

    private static void newState() {
        Thread thread = new Thread();
        System.out.println("newState:" + thread.getState());
    }

    private static void runnableState() {
        Thread thread = new Thread(() -> {
            while (true) {
            }
        });
        thread.start();
        System.out.println("runnableState:" + thread.getState());
    }

    private static void blockedState() {
        Thread thread1 = new Thread(() -> {
            synchronized (ThreadState.class) {
                while (true) {
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            synchronized (ThreadState.class) {

            }
        });
        thread2.start();
        System.out.println("blockedState:" + thread2.getState());
    }

    private static void waitingState() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (true) {
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2.start();
        System.out.println("waitingState:" + thread2.getState());
    }

    private static void timedWaitingState() {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        System.out.println("timedWaitingState:" + thread.getState());
    }

    private static void terminatedState() {
        Thread thread = new Thread();
        thread.start();
        System.out.println("terminatedState:" + thread.getState());
    }
}

