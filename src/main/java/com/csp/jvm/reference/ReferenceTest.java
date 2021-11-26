package com.csp.jvm.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ReferenceTest {

    public static void main(String[] args) {
        String s1 = "a";
        SoftReference<String> softReference = new SoftReference<>(s1);
        WeakReference<String> weakReference = new WeakReference<>(s1);
        ReferenceQueue referenceQueue = new ReferenceQueue();
        referenceQueue.poll();
        PhantomReference<String> phantomReference = new PhantomReference<>(s1, referenceQueue);
    }

}
