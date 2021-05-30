package com.csp.collection;

public class RecursiveDemo {
    public static void main(String[] args) {
        /**
         * 求5的阶乘
         */
//        System.out.println(multiply(5));

        /**
         * 斐波那契数列
         */
        System.out.println(caculateRabbit(6));
    }

    private static int multiply(int n){
        if (n == 1) {
            return 1;
        }else {
            return n*multiply(n-1);
        }
    }
    // 1 1 2 3 5 8
    private static int caculateRabbit(int month){
        if (month == 1 || month ==2) {
            return 1;
        } else {
            return caculateRabbit(month-1)+caculateRabbit(month-2);
        }
    }
}
