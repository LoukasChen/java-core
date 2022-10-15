package com.csp.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/5/8
 */
public class SimpleDateFormatterApi {

    private static final ThreadLocal<SimpleDateFormat> SIMPLE_DATE_FORMAT_THREAD_LOCAL =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws Exception {
        SimpleDateFormatterApi simpleDateFormatterApi = new SimpleDateFormatterApi();
        simpleDateFormatterApi.test();
    }

    private void test() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 20; i++) {
            //提交20个并发解析时间的任务到线程池，模拟并发环境
            threadPool.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    try {
                        System.out.println(SIMPLE_DATE_FORMAT_THREAD_LOCAL.get().parse("2020-01-01 11:12:13"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
    }
}
