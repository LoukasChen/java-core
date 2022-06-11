package com.csp.jvm.imitate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/10/7
 */
public class HeapOOM {

    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new ArrayList<>();
        while (true) {
            TimeUnit.SECONDS.sleep(3);
            list.add(new Object());
        }
    }

}
