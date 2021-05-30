package com.csp.concurrency.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/05/05
 */
public class ThenComposeFuture {

    public static void main(String[] args) {
        thenCompose();
    }

    private static void thenCompose() {
        Function<String, CompletableFuture<String>> fn = t -> CompletableFuture.supplyAsync(CompletableSupplier.supplierDelay(1, t.concat("thenCompose")));
        CompletableFuture.supplyAsync(CompletableSupplier.supplierDelay(1, "supplyAsync"))
                .thenCompose(fn)
                .thenApply(String::toUpperCase)
                .thenAccept(System.out::println);
    }
}
