package com.csp.concurrency.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/11/6
 */
public class ScheduledThreadPoolApi {

    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

    public static void main(String[] args) {
        ScheduledThreadPoolApi api = new ScheduledThreadPoolApi();
//        api.schedule();
        api.scheduleAtFixedRate();
        api.scheduleWithFixedDelay();

//        api.executorService.shutdown();
    }

    private void schedule() {
        executorService.schedule(() -> System.out.println("1"), 1000, TimeUnit.MILLISECONDS);
    }

    /**
     * 绝对间隔时间
     */
    private void scheduleAtFixedRate() {
        executorService.scheduleAtFixedRate(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2");
        }, 1, 2, TimeUnit.SECONDS);
    }

    /**
     * 任务实际耗时的间隔
     */
    private void scheduleWithFixedDelay() {
        executorService.scheduleWithFixedDelay(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("3");
        }, 1, 2, TimeUnit.SECONDS);
    }
}
