package com.csp.concurrency.completableFuture;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: csp52872
 * @date: 2020/10/03
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Double> completableFuture = CompletableFuture.supplyAsync(CompletableFutureTest::fetchPrice);
        CompletableFuture<Double> completableFuture1 = CompletableFuture.supplyAsync(CompletableFutureTest::fetchPriceMore);
//        CompletableFuture.anyOf(completableFuture, completableFuture1).join();
        List<CompletableFuture> list = new ArrayList<>();
        CompletableFuture.allOf(completableFuture, completableFuture1).join();
        completableFuture.thenAccept((res) -> System.out.println(res));
        // lambda写法
        completableFuture.thenAccept(result -> System.out.println("price: " + result));
        // 方法引用
        completableFuture.thenAccept(CompletableFutureTest::print);
        completableFuture.exceptionally(CompletableFutureTest::ex);
        completableFuture.exceptionally(e -> {
            e.printStackTrace();
            System.out.println("run error");
            return null;
        });
        Thread.sleep(200);
        int i = 0;
        while (i < 10) {
            List<CompletableFuture<Void>> completableFutureList = new ArrayList<>();
            List<Void> voidList = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> System.out.println("test" + System.currentTimeMillis()));
                completableFutureList.add(runAsync);
            }
            CompletableFuture.allOf(completableFuture, completableFuture1).join();
            CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[completableFutureList.size()]))
                    .whenComplete((k, v) -> completableFutureList.forEach(r -> voidList.add(r.join()))).join();
            i++;
            System.out.println(voidList.toString());
        }
        exceptionNoHandle();
        try {
            exceptionHandle();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Double fetchPrice() {
        try {
            System.out.println("fetchPrice start");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
        }
        return 20.5;
    }

    private static Double fetchPriceMore() {
        try {
            System.out.println("fetchPriceMore start");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
        }
        return 32.5;
    }

    private static void print(Double result) {
        System.out.println("price: " + result);
    }

    private static Double ex(Throwable throwable) {
        return null;
    }

    private static void exceptionNoHandle() throws RuntimeException {

    }

    private static void exceptionHandle() throws IOException {

    }
}
