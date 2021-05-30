package com.csp.array;

/**
 * @description: 可变参数
 * @author: csp52872
 * @date: 2020/10/04
 */
public class MultipleParams {
    public static void main(String[] args) {
        MultipleParams.params(1, new String[]{"java", "scala"});
    }

    /**
     * @param id
     * @param params 可变长度的参数实际为一个数组，并且只能有一个，位于参数的最后一位
     */
    private static void params(int id, String... params) {
        for (String param : params) {
            System.out.println(param);
        }
    }
}
