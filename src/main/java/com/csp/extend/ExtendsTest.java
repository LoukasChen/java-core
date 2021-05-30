package com.csp.extend;

/**
 * @description: 继承的子父类加载过程
 * @author: csp52872
 * @date: 2020/11/21
 */
public class ExtendsTest {
    public static void main(String[] args) {
        Son son = new Son();
        son.action();
        System.out.println(son.b);
        Father father = son;
        father.action();
        System.out.println(father.b);
    }

    static class Father {
        public static int a;
        public int b;

        static {
            System.out.println("父类静态代码块 a=" + a);
            a = 1;
        }

        {
            System.out.println("父类实例代码块 b=" + b);
            b = 1;
        }

        public Father() {
            System.out.println("父类构造方法 b=" + b);
            b = 2;
        }

        public void action() {
            System.out.println("父类action");
            test();
        }

        protected void test() {
            System.out.println("父类test方法 a=" + a);
            System.out.println("父类test方法 b=" + b);
            b = 5;
        }

    }

    static class Son extends Father {
        public static int a;
        public int b;
        private ExtendsTest extendsTest = new ExtendsTest();

        static {
            System.out.println("子类静态代码块 a=" + a);
            a = 1;
        }

        {
            System.out.println(extendsTest.toString());
            System.out.println("子类实例代码块 b=" + b);
            b = 1;
        }

        public Son() {
            System.out.println("子类构造方法 b=" + b);
            b = 2;
        }

        public void test() {
            System.out.println("子类test方法 a=" + a);
            System.out.println("子类test方法 b=" + b);
            b = 4;
        }
    }
}
