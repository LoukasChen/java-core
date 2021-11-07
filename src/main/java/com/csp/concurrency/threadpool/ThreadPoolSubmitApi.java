package com.csp.concurrency.threadpool;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/11/6
 */
public class ThreadPoolSubmitApi {

    private ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws Exception {
        ThreadPoolSubmitApi api = new ThreadPoolSubmitApi();
        api.invokeAll();
        api.invokeAllWithTimeout(1, TimeUnit.MILLISECONDS);
        api.invokeAny();
        api.invokeAllWithTimeout(1, TimeUnit.SECONDS);

        api.executorService.shutdown();
    }

    private void invokeAll() throws InterruptedException {
        Callable<String> callable1 = () -> "1";
        Callable<String> callable2 = () -> "2";
        Callable<String> callable3 = () -> "3";

        List<Callable<String>> list = Stream.of(callable1, callable2, callable3).collect(Collectors.toList());
        List<Future<String>> futures = executorService.invokeAll(list);
        futures.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    private void invokeAllWithTimeout(long timeout, TimeUnit unit) throws InterruptedException {
        Callable<String> callable1 = () -> "4";
        Callable<String> callable2 = () -> "5";
        Callable<String> callable3 = () -> {
            TimeUnit.SECONDS.sleep(1);
            return "6";
        };

        List<Callable<String>> list = Stream.of(callable1, callable2, callable3).collect(Collectors.toList());
        List<Future<String>> futures = executorService.invokeAll(list, timeout, unit);
        futures.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    private void invokeAny() throws Exception {
        Callable<String> callable1 = () -> "1";
        Callable<String> callable2 = () -> "2";
        Callable<String> callable3 = () -> "3";

        List<Callable<String>> list = Stream.of(callable1, callable2, callable3).collect(Collectors.toList());
        String result = executorService.invokeAny(list);
        System.out.println(result);
    }

    private void invokeAnyWithTimeout(long timeout, TimeUnit unit) throws Exception {
        Callable<String> callable1 = () -> "4";
        Callable<String> callable2 = () -> "5";
        Callable<String> callable3 = () -> {
            TimeUnit.SECONDS.sleep(1);
            return "6";
        };

        List<Callable<String>> list = Stream.of(callable1, callable2, callable3).collect(Collectors.toList());
        String result = executorService.invokeAny(list, timeout, unit);
        System.out.println(result);
    }

}
