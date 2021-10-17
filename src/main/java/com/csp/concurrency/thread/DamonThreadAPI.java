package com.csp.concurrency.thread;

/**
 * @desc: 守护线程:在其他非守护线程全部执行完成后，守护线程也会随之停止
 * @author: csp52872
 * @date: 2021/10/17
 */
public class DamonThreadAPI {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("damon thread stop"), "damon");
        thread.setDaemon(true);
        thread.start();
        System.out.println("main thread stop");
    }
}
