package com.csp.string;

/**
 * @desc: String intern
 * @author: csp52872
 * @date: 2021/11/13
 */
public class StringIntern {
    public static void main(String[] args) {
        String s1 = new String("a"); // 堆上创建一个字符串"a"对象
        String s2 = s1.intern();// 入池，返回池中的对象
        String s3 = "a";
        System.out.println(s1 == s3);

        String s4 = new String("a") + new String("a");
        s4.intern();
        String s5 = "aa";
        System.out.println(s4 == s5);

        String str = new StringBuilder("intern").append("test").toString();
        System.out.println(str.intern() == str); //

        String java = new StringBuilder("ja").append("va").toString();
        System.out.println(java.intern() == java); // false
    }

}
