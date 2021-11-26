package com.csp.string;

/**
 * @desc: 反转字符串
 * @author: csp52872
 * @date: 2021/11/13
 */
public class StringReverse {

    public static void main(String[] args) {
        String str = "java";
        System.out.println(reverseByStringBuilder(str));
        System.out.println(reverseByCharArray(str));
    }

    public static String reverseByStringBuilder(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        return stringBuilder.reverse().toString();
    }

    public static String reverseByCharArray(String str) {
        String res = "";
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            res += chars[i];
        }
        return res;
    }
}
