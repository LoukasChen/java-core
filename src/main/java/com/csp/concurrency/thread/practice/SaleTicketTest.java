package com.csp.concurrency.thread.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @desc: 卖票
 * @author: csp52872
 * @date: 2021/10/20
 */
public class SaleTicketTest {

    public static void main(String[] args) {
        SaleTicket saleTicket = new SaleTicket();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Integer> list = new ArrayList<>();
        List<CompletableFuture<Integer>> completableFutures = Stream.iterate(0, i -> i + 1).limit(1000)
                .map(th -> CompletableFuture.supplyAsync(() -> saleTicket.sell(new Random().nextInt(5) + 1), executorService))
                .collect(Collectors.toList());
        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()]))
                .whenComplete((res, ex) -> completableFutures.forEach(ct -> list.add(ct.join())))
                .join();
        System.out.println(list.stream().mapToInt(Integer::intValue).sum());
        System.out.println(saleTicket.getCount());
        executorService.shutdown();
    }

    private static class SaleTicket {

        private int count = 1000;

        public int getCount() {
            return this.count;
        }

        public synchronized int sell(int count) {
            if (this.count > count) {
                this.count -= count;
                return count;
            } else {
                return 0;
            }
        }
    }

}
