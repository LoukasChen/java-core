package com.csp.concurrency.completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/05/05
 */
public class ThenRunFuture {

    public static void main(String[] args) {
        thenRun();
        thenRunAsync();
    }

    /**
     * thenRun 同步执行
     */
    private static void thenRun() {
        Runnable r1 = () -> System.out.println("Runnable1");
        Runnable r2 = () -> System.out.println("Runnable2");
        Runnable r3 = () -> System.out.println("Runnable3");
        CompletableFuture.runAsync(r1).thenRun(r2).thenRun(r3);
    }

    /**
     * thenRun 异步执行
     */
    private static void thenRunAsync() {
        Runnable r1 = () -> System.out.println("Runnable1");
        Runnable r2 = () -> System.out.println("Runnable2");
        Runnable r3 = () -> System.out.println("Runnable3");
        CompletableFuture.runAsync(r1).thenRunAsync(r2).thenRunAsync(r3).join();
    }
}
