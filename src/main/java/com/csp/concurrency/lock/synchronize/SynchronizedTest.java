package com.csp.concurrency.lock.synchronize;

/**
 * @description: 锁的可重入性
 * @author: csp
 * @date: 2020/02/16
 */
public class SynchronizedTest {

    private int count = 0;

    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest test = new SynchronizedTest();
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(new Task(test));
            threads[i].start();
        }
        for (int i = 0; i < 100; i++) {
            threads[i].join();
        }

        System.out.println(test.getCount());

//        test.eat();
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public synchronized void eat() {
        System.out.println("eat something!!!");
        // 如果synchronized不具备可重入性，调用drink方法会产生死锁。
        drink();
    }

    public synchronized void drink() {
        System.out.println("drink is happy!!!");
    }

    static class Task implements Runnable {

        private SynchronizedTest synchronizedTest;

        public Task(SynchronizedTest synchronizedTest) {
            this.synchronizedTest = synchronizedTest;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                synchronizedTest.increment();
            }
        }
    }
}
