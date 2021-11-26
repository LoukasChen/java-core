package com.csp.jvm.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 软引用 在程序OOM前才会触发GC回收
 * @author: csp52872
 * @date: 2021/11/14
 */
public class SoftReferenceTest {

    private static final int _5M = 1024 * 1024 * 5;

    public static void main(String[] args) {
//        oom_heap_space();
//        softReference();
        referenceQueue();
    }

    private static void oom_heap_space() {
        List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            // 设置 虚拟机参数：堆最大为20M -Xmx20m
            //  OOM:Java heap space
            list.add(new byte[_5M]);
        }
        System.out.println(list);
    }

    private static void softReference() {
        List<Reference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            // 发生OOM前，发现是软引用，GC就自动回收了
            Reference<byte[]> softReference = new SoftReference<>(new byte[_5M]);
            System.out.println(softReference.get());
            list.add(softReference);
        }
        list.forEach(ref -> System.out.println(ref.get()));
    }

    private static void referenceQueue() {
        List<Reference<byte[]>> list = new ArrayList<>();
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
        for (int i = 0; i < 5; i++) {
            // 关联引用队列，当软引用关联的byte[]被回收时，软引用会加入到引用队列中
            Reference<byte[]> reference = new SoftReference<>(new byte[_5M], queue);
            System.out.println(reference.get());
            list.add(reference);
        }
        // 从引用队列获取引用对象
        Reference<? extends byte[]> ref = queue.poll();
        while (ref != null) {
            // list清除无效引用
            list.remove(ref);
            ref = queue.poll();
        }
        System.out.println("========================");
        list.forEach(r -> System.out.println(r.get()));
    }

}
