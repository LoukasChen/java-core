package com.csp.concurrency.thread;

/**
 * @description: 各种变量线程安全性测试
 * @author: csp
 * @date: 2020/02/22
 */
public class ThreadSafeTest implements Runnable {
    /**
     * 静态变量，多线程环境下线程不安全
     */
//    private static int num;

    /**
     * 实例变量，单例环境下线程不安全，多实例情况下线程安全
     */
    private int num;

    public static void main(String[] args) {
//        ThreadSafeTest t = new ThreadSafeTest();
        for (int i = 0; i < 5000; i++) {
            new Thread(new ThreadSafeTest(), "线程" + i).start();
        }
    }

    @Override
    public void run() {
        // 局部变量，为线程栈私有，线程安全
        int num = 2;
//        num = 2;
        System.out.println(Thread.currentThread().getName() + "--num的值=" + num);
        num = 5;
        System.out.println(Thread.currentThread().getName() + "--num*2的值=" + num * 2);
    }
}
