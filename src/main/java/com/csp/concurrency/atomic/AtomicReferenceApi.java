package com.csp.concurrency.atomic;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BinaryOperator;

/**
 * @description: AtomicReference 原子引用，支持泛型
 * @author: csp52872
 * @date: 2021/05/29
 */
public class AtomicReferenceApi {

    private final AtomicReference<BigDecimal> bigDecimal = new AtomicReference<>(new BigDecimal("100"));

    public static void main(String[] args) {
        AtomicReferenceApi atomicReference = new AtomicReferenceApi();
        BigDecimal res = atomicReference.getAndSet(new BigDecimal("201"));
        System.out.println(res);

        BigDecimal accumulate = atomicReference.accumulate(new BigDecimal("10"), (x, y) -> x.multiply(y));
        System.out.println(accumulate);
    }

    private BigDecimal getAndSet(BigDecimal bigDecimal) {
        return this.bigDecimal.getAndSet(bigDecimal);
    }

    private BigDecimal accumulate(BigDecimal bigDecimal, BinaryOperator<BigDecimal> binaryOperator) {
        return this.bigDecimal.accumulateAndGet(bigDecimal, binaryOperator);
    }

}
