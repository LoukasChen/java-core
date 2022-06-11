package com.csp.concurrency.threadLocal;

/**
 * @description: ThreadLocal
 * @author: csp52872
 * @date: 2020/11/14
 */
public class ThreadLocalApi {

    // 初始化一个ThreadLocal变量
//    private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "mainThread");
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws Exception {
        threadLocal.set("mainThread");
        // threadLocal持有主线程的值
        System.out.println(threadLocal.get());

        Thread threadA = new Thread(new ThreadA());
        Thread threadB = new Thread(new ThreadB());
        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println(threadLocal.get());
    }

    static class ThreadA implements Runnable {

        @Override
        public void run() {
            System.out.println("Before Set ThreadA Value:" + threadLocal.get());
            threadLocal.set("ThreadA");
            System.out.println("After Set ThreadA Value:" + threadLocal.get());
        }
    }

    static class ThreadB implements Runnable {

        @Override
        public void run() {
            System.out.println("Before Set ThreadB Value:" + threadLocal.get());
            threadLocal.set("ThreadB");
            System.out.println("After Set ThreadB Value:" + threadLocal.get());
        }
    }

}
