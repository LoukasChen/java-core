package com.csp.concurrency.completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/05/06
 */
public class ThenCombineFuture {

    public static void main(String[] args) {
        thenCombine();
    }

    private static void thenCombine() {
        CompletableFuture.supplyAsync(CompletableSupplier.supplierDelay(1, "supplyAsync"))
                .thenCombine(CompletableFuture.supplyAsync(CompletableSupplier.supplierDelay(1, "supplyAsync")),
                        (i, j) -> i + j)
                .thenAccept(System.out::println);
    }

}
