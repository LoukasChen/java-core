package com.csp.concurrency.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/05/05
 */
public class RunAfterBothFuture {

    public static void main(String[] args) {
        runAfterBoth();
        runAfterEither();
    }

    private static void runAfterBoth() {
        AtomicBoolean state = new AtomicBoolean(false);
        CompletableFuture.supplyAsync(CompletableSupplier.supplierDelay(1, "supplyAsync"))
                .runAfterBoth(CompletableFuture.supplyAsync(CompletableSupplier.supplierDelay(1, "runAfterBoth"))
                                .thenAccept(System.out::println),
                        () -> state.set(true));
        System.out.println(state);
    }

    private static void runAfterEither() {
        AtomicBoolean state = new AtomicBoolean(false);
        CompletableFuture.supplyAsync(CompletableSupplier.supplierDelay(1, "supplyAsync"))
                .runAfterEither(CompletableFuture.supplyAsync(CompletableSupplier.supplierDelay(1, "runAfterBoth"))
                                .thenAccept(System.out::println),
                        () -> state.set(true));
        System.out.println(state);
    }

}
