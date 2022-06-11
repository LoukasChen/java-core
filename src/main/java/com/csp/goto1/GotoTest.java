package com.csp.goto1;

/**
 * @desc: goto
 * @author: csp52872
 * @date: 2022/2/20
 */
public class GotoTest {

    public static void main(String[] args) {
        retry:
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    System.out.println("11");
                    break retry;
                }
            }
        }
        System.out.println("goto");
    }
}
