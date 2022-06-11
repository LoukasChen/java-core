package com.csp.concurrency.completableFuture;

import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/5/22
 */
public class ApplyToEitherApi {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "su";
        }).whenComplete((r, ex) -> {
            if (r != null) {
                System.out.println(r);
            }
        }).exceptionally(ex -> {
            throw new RuntimeException(ex);
        }).join();
    }

//    public static <T> CompletableFuture<T> within(CompletableFuture<T> cf, long timeout, TimeUnit unit) {
//        CompletableFuture<T> timeAfterFuture = timeAfter(,timeout, unit);
//        return cf.applyToEither(timeAfterFuture, Function.identity());
//    }

    public static <T> CompletableFuture<T> timeAfter(Supplier<T> supplier, long timeout, TimeUnit unit) {
        CompletableFuture<T> completableFuture = new CompletableFuture<>();
        Delayer.delay(() -> completableFuture.complete(supplier.get()), timeout, unit);
        return completableFuture;
    }

    static final class Delayer {

        static final ScheduledThreadPoolExecutor delayer;

        static {
            (delayer = new ScheduledThreadPoolExecutor(1, new DaemonThreadFactory())).setRemoveOnCancelPolicy(true);
        }

        static final class DaemonThreadFactory implements ThreadFactory {

            public Thread newThread(Runnable runnable) {
                Thread t = new Thread(runnable);
                t.setDaemon(true);
                t.setName("CompletableFutureDelayScheduler");
                return t;
            }

        }

        static ScheduledFuture<?> delay(Runnable runnable, long delay, TimeUnit timeUnit) {
            System.out.println("queueSize="+ delayer.getQueue().size());
            return delayer.schedule(runnable, delay, timeUnit);
        }

    }
}
