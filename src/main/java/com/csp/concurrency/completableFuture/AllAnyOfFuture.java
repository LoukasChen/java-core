package com.csp.concurrency.completableFuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: 构建依赖的多个阶段的任务流
 * @author: csp52872
 * @date: 2021/05/06
 */
public class AllAnyOfFuture {

    public static void main(String[] args) {
        allOf();
        anyOf();
    }

    private static List<CompletableFuture<Integer>> task() {
        return Stream.iterate(0, n -> n + 2).limit(1000)
                .map(i -> CompletableFuture.supplyAsync(() -> i))
                .collect(Collectors.toList());
    }

    /**
     * allOf 所有任务都完成
     */
    private static void allOf() {
        List<CompletableFuture<Integer>> completableFutureList = task();
        CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[completableFutureList.size()])).join();

    }

    /**
     * anyOf 任意一个任务完成
     */
    private static void anyOf() {
        List<CompletableFuture<Integer>> completableFutureList = task();
        Object object = CompletableFuture.anyOf(completableFutureList.toArray(new CompletableFuture[completableFutureList.size()])).join();
        System.out.println(object);
    }
}
