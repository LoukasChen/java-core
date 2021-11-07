package com.csp.concurrency.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @desc: 线程池的异常处理
 * @author: csp52872
 * @date: 2021/11/6
 */
public class ThreadPoolExceptionApi {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 传入callable可以拿到异常返回值
        Future<Boolean> future = executorService.submit(() -> {
            System.out.println("模拟异常信息");
            int i = 1 / 0;
            return true;
        });
        System.out.println(future.get());
    }
}
