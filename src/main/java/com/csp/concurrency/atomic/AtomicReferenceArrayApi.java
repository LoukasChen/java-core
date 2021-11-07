package com.csp.concurrency.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/11/6
 */
public class AtomicReferenceArrayApi {

    private AtomicReferenceArray<String> array = new AtomicReferenceArray<>(10);

    public static void main(String[] args) {
        AtomicReferenceArrayApi api = new AtomicReferenceArrayApi();
        System.out.println(api.updateAndGet());
    }

    private String updateAndGet() {
        return this.array.updateAndGet(0, x -> "str");
    }
}
