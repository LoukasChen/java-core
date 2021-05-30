package com.csp.concurrency.thread;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @description: join
 * @author: csp
 * @date: 2020/02/01
 */
public class JoinAPI {
    public static void main(String[] args) throws InterruptedException {
        // 创建两个线程
        List<Thread> threadList = IntStream.range(1, 3).mapToObj(JoinAPI::createThread).collect(Collectors.toList());
        // 启动两个线程
        threadList.forEach(Thread::start);
        // 执行两个线程的join方法
        for (Thread thread : threadList) {
            thread.join();
        }
        // main线程输出
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "#" + i);
            shortSleep();
        }
    }

    /**
     * 创建一个线程
     * @param seq
     * @return
     */
    private static Thread createThread(int seq) {
        return new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "#" + i);
                shortSleep();
            }
        }, String.valueOf(seq));
    }


    private static void shortSleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
