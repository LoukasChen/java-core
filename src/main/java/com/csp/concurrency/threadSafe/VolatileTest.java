package com.csp.concurrency.threadSafe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: csp52872
 * @date: 2021/11/3
 */
public class VolatileTest {

    private static int count;
    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    private static void test() throws InterruptedException {
        new Thread(() -> {
            while (flag) {
                System.out.println();
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        // 不加volatile 线程永远停不下来，因为读取的工作内存的共享变量的副本
        flag = false;
    }

    private static void read() {
        if (flag) {
            count++;
        }
    }

    private static void write() {
        count = 1;
        flag = false;
    }
}
