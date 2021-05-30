package com.csp.concurrency.completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/05/05
 */
public class ThenAcceptAndApplyFuture {

    public static void main(String[] args) {
        thenAcceptAndApply();
        thenAcceptAndApplyAsync();
    }

    private static void thenAcceptAndApply() {
        CompletableFuture.supplyAsync(CompletableSupplier.supplierDelay(1, "thenAcceptAndApply"))
                .thenApply(String::toUpperCase)
                .thenAccept(System.out::println);
    }

    private static void thenAcceptAndApplyAsync() {
        CompletableFuture.supplyAsync(CompletableSupplier.supplierDelay(1, "thenAcceptAndApplyAsync"))
                .thenApplyAsync(String::toUpperCase)
                .thenAcceptAsync(System.out::println)
                .join();
    }

}
