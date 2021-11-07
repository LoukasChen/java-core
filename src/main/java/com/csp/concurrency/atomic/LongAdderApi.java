package com.csp.concurrency.atomic;

import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @desc: LongAdder
 * @author: csp52872
 * @date: 2021/11/6
 */
public class LongAdderApi {

    public static void main(String[] args) {
        LongAdderApi api = new LongAdderApi();
        api.atomicOps(() -> new LongAdder(), x -> x.increment());
    }

    private <T> void atomicOps(Supplier<T> supplier, Consumer<T> consumer) {
        T t = supplier.get();
        consumer.accept(t);
        System.out.println(t.toString());
    }
}
