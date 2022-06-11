package com.csp.collection.list;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @desc: 写时拷贝的ArrayList
 * @author: csp52872
 * @date: 2021/11/28
 */
public class CopyOnWriteArrayListApi {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("copy");
        copyOnWriteArrayList.get(0);

        copyOnWriteArrayList.remove("copy");
    }
}
