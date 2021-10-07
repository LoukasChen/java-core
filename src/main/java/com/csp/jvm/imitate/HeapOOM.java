package com.csp.jvm.imitate;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/10/7
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        while (true) {
            list.add(new Object());
        }
    }

}
