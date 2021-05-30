package com.csp.concurrency.completableFuture;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @author: csp52872
 * @date: 2021/05/05
 */
public class CompletableSupplier {

    public static <T> Supplier<T> supplier(T t) {
        return () -> t;
    }

    public static <T> Supplier<T> supplierDelay(Integer time, T t) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return () -> t;
    }
}
