package com.csp.concurrency.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @desc: 闭锁
 * @author: csp52872
 * @date: 2021/11/9
 */
public class CountDownLatchApi {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Worker(countDownLatch));
        }
        countDownLatch.await();
        System.out.println("release lock");

        executorService.shutdown();
    }

    public static class Worker implements Runnable {

        private CountDownLatch countDownLatch;

        public Worker(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            doWork();
            countDownLatch.countDown();
            System.out.println("countDown:" + countDownLatch.getCount());
        }

        private void doWork() {

        }
    }
}
