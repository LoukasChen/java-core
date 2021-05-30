package com.csp.string;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/**
 * @author csp
 * @description: String
 * @date 2019/9/28 22:53
 */
public class StringDemo {

    public static void main(String[] args) {
        String s1 = new String("a");
        s1.intern();
        String s2 = "a";
        System.out.println(s1 == s2);

        String s3 = new String("a") + new String("a");
        s3.intern();
        String s4 = "aa";
        System.out.println(s3 == s4);
        SoftReference<String> softReference = new SoftReference<>(s1);
        WeakReference<String> weakReference = new WeakReference<>(s1);
        ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference<String> phantomReference = new PhantomReference<>(s1, referenceQueue);


//        StringBuilder sb = new StringBuilder("abc");
//        StringBuilder sbReverse = sb.reverse();
//        System.out.println(sbReverse);

        String str = "abc";
        String strReverse = "";
        char[] charArray = str.toCharArray();
        for (int i = charArray.length - 1; i >= 0; --i) {
            strReverse += charArray[i];
        }
        System.out.println(strReverse);

        intern();

        string();
    }

    public static void intern() {
        String str = new StringBuilder("intern").append("test").toString();
        System.out.println(str.intern() == str);

        String java = new StringBuilder("ja").append("va").toString();
        System.out.println(java.intern() == java);
    }

    public static void string() {
        String s1 = new String("s1");
        String s2 = "s1";
        System.out.println(s1.equals(s2));
        String s3 = s1.substring(0, 1);
        char[] chars = s1.toCharArray();
        new Thread(()-> System.out.println(123)).start();
    }
}
