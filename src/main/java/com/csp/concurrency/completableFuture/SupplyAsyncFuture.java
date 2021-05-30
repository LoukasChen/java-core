package com.csp.concurrency.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/05/05
 */
public class SupplyAsyncFuture {

    public static void main(String[] args) {
        supplyAsync();
        supplyAsyncWithThreadPool();
    }

    private static void supplyAsync() {
        CompletableFuture.supplyAsync(supplierDelay(1, "supplyAsync"))
                .whenComplete((res, e) -> {
                    if (res != null) {
                        System.out.println(res);
                    }
                    if (e != null) {
                        e.printStackTrace();
                    }
                });
    }

    private static void supplyAsyncWithThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CompletableFuture.supplyAsync(supplierDelay(2, "supplyAsyncWithThreadPool"), executorService)
                .whenComplete((res, e) -> {
                    if (res != null) {
                        System.out.println(res);
                    }
                    if (e != null) {
                        e.printStackTrace();
                    }
                });
        executorService.shutdown();
    }

    private static <T> Supplier<T> supplier(T t) {
        return () -> t;
    }

    private static <T> Supplier<T> supplierDelay(Integer time, T t) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return () -> t;
    }
}
