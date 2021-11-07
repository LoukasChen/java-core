package com.csp.concurrency.atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/11/5
 */
public class AtomicMarkableReferenceApi {

    private final AtomicMarkableReference<String> atomicMarkableRef = new AtomicMarkableReference<>("atomic", true);

    public static void main(String[] args) {
        AtomicMarkableReferenceApi atomicMarkableReferenceApi = new AtomicMarkableReferenceApi();
        System.out.println(atomicMarkableReferenceApi.compareAndSet());
        System.out.println(atomicMarkableReferenceApi.compareAndSet());
    }

    private boolean compareAndSet() {
        String reference = atomicMarkableRef.getReference();
        return this.atomicMarkableRef.compareAndSet(reference, "markable", true, false);
    }
}
