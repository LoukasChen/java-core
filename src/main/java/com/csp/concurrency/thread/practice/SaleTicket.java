package com.csp.concurrency.thread.practice;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 模拟卖票程序
 * @author: csp
 * @date: 2020/01/29
 */
public class SaleTicket implements Runnable {

    private static final int MAX_TICKET = 50;

    //    private static int index = 0;
    private AtomicInteger index = new AtomicInteger(0);


    @Override
    public void run() {
        while (index.get() < MAX_TICKET) {
            System.out.println("柜台：" + Thread.currentThread().getName() + "当前号码是：" + index.getAndIncrement());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SaleTicket saleTicket = new SaleTicket();
        Thread s1 = new Thread(saleTicket, "一号");

        s1.start();
        TimeUnit.MILLISECONDS.sleep(10);
        s1.interrupt();
//        Thread s2 = new Thread(saleTicket, "二号");
//        s2.start();
//
//        Thread s3 = new Thread(saleTicket, "三号");
//        s3.start();
//
//        Thread s4 = new Thread(saleTicket, "四号");
//        s4.start();
    }
}
