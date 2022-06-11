package com.csp.collection.set;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @desc: 底层调用了CopyOnWriteArrayList，数据不重复
 * @author: csp52872
 * @date: 2021/11/28
 */
public class CopyOnWriteArraySetApi {

    public static void main(String[] args) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.add("copy");
        copyOnWriteArraySet.remove("copy");
    }
}
