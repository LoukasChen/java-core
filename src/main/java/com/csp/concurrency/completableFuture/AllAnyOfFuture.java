package com.csp.concurrency.completableFuture;

import java.sql.Time;
import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description: 构建依赖的多个阶段的任务流
 * @author: csp52872
 * @date: 2021/05/06
 */
public class AllAnyOfFuture {

    private final static ExecutorService executorService = new ThreadPoolExecutor(20, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(500));

    public static void main(String[] args) throws InterruptedException {
        allOfWithResult();
//        allOfWithoutResult();
//        anyOf();
    }

    private static List<CompletableFuture<Integer>> task() {
        return Stream.iterate(0, n -> n + 2).limit(1000)
                .map(i -> CompletableFuture.supplyAsync(() -> i))
                .collect(Collectors.toList());
    }

    /**
     * allOf 所有任务都完成，无返回结果
     */
    private static void allOfWithoutResult() {
        List<CompletableFuture<Integer>> completableFutureList = task();
        CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0])).join();
    }

    private static List<Integer> allOfWithResult() throws InterruptedException {
        long startTime = Instant.now().toEpochMilli();
        List<CompletableFuture<Integer>> completableFutures = IntStream.range(0, 100).mapToObj(r ->
                CompletableFuture.supplyAsync(() -> {
                            try {
                                System.out.println("supplyAsync threadName=" + Thread.currentThread().getName());
                                TimeUnit.MILLISECONDS.sleep(500);
                                return new Random().nextInt(100);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }, executorService)
                        .applyToEither(ApplyToEitherApi.timeAfter(() -> {
                            System.out.println("timeAfter threadName=" + Thread.currentThread().getName());
                            return -999999;
                        }, 3, TimeUnit.SECONDS), Function.identity())
                        .exceptionally(e -> {
                            throw new RuntimeException(e);
                        })
        ).collect(Collectors.toList());

        List<Integer> list = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]))
                .handle((r, e) -> completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList()))
                .join();

        System.out.println(Instant.now().toEpochMilli() - startTime);
        System.out.println(list);
        executorService.shutdown();
        return list;
    }

    /**
     * anyOf 任意一个任务完成
     */
    private static void anyOf() {
        List<CompletableFuture<Integer>> completableFutureList = task();
        Object object = CompletableFuture.anyOf(completableFutureList.toArray(new CompletableFuture[0])).join();
        System.out.println(object);
    }
}
