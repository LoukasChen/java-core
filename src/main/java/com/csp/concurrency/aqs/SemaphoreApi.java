package com.csp.concurrency.aqs;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @desc: 信号量
 * @author: csp52872
 * @date: 2021/11/9
 */
public class SemaphoreApi {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AccessControlService accessControlService = new AccessControlService(100);
        List<CompletableFuture<Boolean>> list = Stream.iterate(0, i -> i++).limit(100)
                .map(item -> CompletableFuture.supplyAsync(() -> accessControlService.login(), executorService))
                .collect(Collectors.toList());
        CompletableFuture.allOf(list.toArray(new CompletableFuture[list.size()])).join();

        System.out.println(accessControlService.permits.availablePermits());

        accessControlService.logout();
        System.out.println(accessControlService.permits.availablePermits());

        executorService.shutdown();
    }

    public static class AccessControlService {

        private Semaphore permits;

        public AccessControlService(int limit) {
            this.permits = new Semaphore(limit);
        }

        public boolean login() {
            if (!permits.tryAcquire()) {
                throw new ConcurrentLimitException();
            }
            return true;
        }

        public void logout() {
            permits.release();
        }

    }

    public static class ConcurrentLimitException extends RuntimeException {
    }
}
