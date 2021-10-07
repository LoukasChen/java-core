package com.csp.innerClass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * @description: 内部类
 * @author: csp52872
 * @date: 2021/01/16
 */
public class OuterClass {

    private String globalVariables = "globalVariables";

    private static String staticVariables = "staticVariables";

    static String acess$1() {
        return staticVariables;
    }

    public void outerMethod() {
        System.out.println("OuterClass.outerMethod() globalVariables=" + globalVariables);
        // 成员方法内部类
        class MethodInnerClass {

            private String method = "method";

            public void get() {
                System.out.println(method);
                System.out.println(staticVariables);
                System.out.println(globalVariables);
            }
        }

        new MethodInnerClass().get();
    }

    public static void staticOuterMethod() {
        System.out.println("OuterClass.staticOuterMethod() staticVariables=" + staticVariables);
        // 静态方法内部类
        class StaticMethodInnerClass {
            private String method = "method";

            public void get() {
                System.out.println(method);
                System.out.println(staticVariables);
            }
        }
        new StaticMethodInnerClass().get();
    }


    /**
     * 静态内部类
     */
    public static class StaticInnerClass {

        private String a = "a";

        private static String b = "b";

        public void innerMethod() {
            // 静态内部类访问外部静态方法
            staticInnerMethod();

            System.out.println("StaticInnerClass.innerMethod() a=" + a);

            System.out.println("StaticInnerClass.innerMethod() b=" + b);

            // 静态内部类的成员方法可以访问外部类的静态变量
            System.out.println("StaticInnerClass.innerMethod() staticVariables=" + OuterClass.acess$1());

            // 静态内部类的成员方法无法访问外部类的成员变量
//            System.out.println("StaticInnerClass.innerMethod() globalVariables=" + globalVariables);
        }

        public static void staticInnerMethod() {
            // 静态内部类访问外部静态方法
            staticOuterMethod();

            // 静态方法无法访问成员变量
//            System.out.println("StaticInnerClass.staticInnerMethod() a=" + a);

            System.out.println("StaticInnerClass.staticInnerMethod() b=" + b);

            // 静态内部类的成员方法可以访问外部类的静态变量
            System.out.println("StaticInnerClass.staticInnerMethod() staticVariables=" + staticVariables);

            // 静态内部类的静态方法无法访问外部类的成员变量
//            System.out.println("StaticInnerClass.staticInnerMethod() globalVariables=" + globalVariables);
        }

    }

    /**
     * 成员内部类
     */
    public class InnerClass {
        // 成员内部类不允许定义静态变量
//        private static String c = "c";
        private String d = "d";

        // 成员内部类不允许定义静态方法
//        public static void staticInnerMethod() {}

        public void innerMethod() {
            outerMethod();

            staticOuterMethod();

            System.out.println("InnerClass.innerMethod() d=" + d);

            // 成员内部类的成员方法可以访问外部类的成员变量
            System.out.println("InnerClass.innerMethod() globalVariables=" + globalVariables);

            // 成员内部类的成员方法可以访问外部类的静态变量
            System.out.println("InnerClass.innerMethod() staticVariables=" + staticVariables);
        }
    }

    public static void main(String[] args) {
        StaticInnerClass.staticInnerMethod();
        new StaticInnerClass().innerMethod();
        System.out.println("==============================");
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();
        innerClass.innerMethod();

        Callee1 callee1 = new Callee1(1, 2) {
            @Override
            public void increment() {
                super.increment();
            }
        };

        Arrays.sort(new Integer[]{3, 1, 2}, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int[] counter = new int[1];
        Date[] dates = new Date[100];
        for (int i = 0; i < dates.length; i++) {
            dates[i] = new Date() {
                @Override
                public int compareTo(Date anotherDate) {
                    counter[0]++;
                    return super.compareTo(anotherDate);
                }
            };
            dates[i].compareTo(new Date());
        }
        System.out.println(counter);
    }
}
