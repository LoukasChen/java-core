package com.csp.jvm.reference;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 弱引用 在发生GC时就会回收
 * @author: csp52872
 * @date: 2021/11/14
 */
public class WeakReferenceTest {

    private static final int _5M = 1024 * 1024 * 5;

    public static void main(String[] args) {
        weakReference();
    }

    private static void weakReference() {
        List<Reference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Reference<byte[]> weakReference = new WeakReference<>(new byte[_5M]);
            System.out.println(weakReference.get());
            list.add(weakReference);
        }
        System.out.println("========================");
        list.forEach(ref -> System.out.println(ref.get()));
    }
}
