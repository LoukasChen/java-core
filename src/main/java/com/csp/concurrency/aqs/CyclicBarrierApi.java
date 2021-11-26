package com.csp.concurrency.aqs;

import java.util.concurrent.*;

/**
 * @desc: 循环栅栏
 * @author: csp52872
 * @date: 2021/11/9
 */
public class CyclicBarrierApi {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println("thread all run end"));

        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("t1 run end");
            });

            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("t2 run end");
            });

            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("t3 run end");
            });

        }

        executorService.shutdown();
    }

}
