package com.csp.string;

/**
 * @desc: StringPool
 * @author: csp52872
 * @date: 2021/11/13
 */
public class StringPool {

    public static void main(String[] args) {
        // 常量池的信息会都会被加载到运行时常量池中，这时a/b/ab都是常量池中的符号，还未成为java字符串对象
        // ldc #2 会把a符号变为"a"字符串对象
        // ldc #3 会把b符号变为"b"字符串对象
        // ldc #4 会把ab符号变为"ab"字符串对象
        // 当程序执行到相应行代码时，StringTable会存储相应的字符串对象["a","b","ab"]，哈希结构，不可扩容

        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2; // new StringBuilder().append(s1).append(s2).toString(); 相当于new String("ab")
        System.out.println(s4 == s3); // false

        String s5 = "a" + "b"; // 编译期间就优化为"ab"字符串了，与s3相同
        System.out.println(s5 == s3); // true
    }
}
