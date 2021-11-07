package com.csp.concurrency.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/11/6
 */
public class NewCachedThreadPoolApi {

    public static void main(String[] args) {
        // 创建一个可缓存的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(System.out::println);

        NewCachedThreadPoolApi api = new NewCachedThreadPoolApi();
        api.syncQueue();
    }

    private void syncQueue() {
        // 只有当队列执行take方法时，put方法才能执行完成
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                synchronousQueue.put(1);
                System.out.println("put 1 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                // 如果队列没有执行take，则put会阻塞住
                synchronousQueue.put(2);
                System.out.println("put 2 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Integer take = synchronousQueue.take();
                System.out.println("take:" + take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
