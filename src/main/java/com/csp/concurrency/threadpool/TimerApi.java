package com.csp.concurrency.threadpool;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/11/6
 */
public class TimerApi {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("1");
            }
        }, 1000L);
    }
}
