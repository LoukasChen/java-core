package com.csp.concurrency.thread;

/**
 * @description: ThreadLocal
 * @author: csp52872
 * @date: 2020/11/14
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {
        // 设置主线程本地变量初始值
        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> {
            System.out.println("initialValue");
            return "thread id =" + Thread.currentThread().getId();
        });
        threadLocal.set("set threadlocal value");
        threadLocal.remove();
        System.out.println(threadLocal.get());

        new Thread(new ThreadA(threadLocal)).start();
        new Thread(new ThreadB(threadLocal)).start();
    }

    static class ThreadA implements Runnable {

        private ThreadLocal<String> threadLocal;

        public ThreadA(ThreadLocal<String> threadLocal) {
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            threadLocal.set("ThreadA");
            System.out.println("ThreadA print=" + threadLocal.get());
        }
    }

    static class ThreadB implements Runnable {

        private ThreadLocal<String> threadLocal;

        public ThreadB(ThreadLocal<String> threadLocal) {
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            threadLocal.set("ThreadB");
            System.out.println("ThreadB print=" + threadLocal.get());
        }
    }

}
