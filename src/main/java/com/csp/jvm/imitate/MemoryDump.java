package com.csp.jvm.imitate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/10/10
 */
public class MemoryDump {

    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            list.add(new Object());
        }
        TimeUnit.MINUTES.sleep(10);
    }

    private static class Object {

        private static final byte[] bytes = new byte[1024 * 1024];

    }

}
