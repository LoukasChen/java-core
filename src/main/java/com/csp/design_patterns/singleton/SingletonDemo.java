package com.csp.design_patterns.singleton;

/**
 * @author csp
 * @description: TODO
 * @date 2019/9/29 22:01
 */
public class SingletonDemo {
    /**
     * 懒汉式
     * volatile可以禁止指令重排
     */
    private volatile static SingletonDemo singleton = null;

    /**
     * 饿汉式
     */
//    private static SingletonDemo singleton = new SingletonDemo();

    private SingletonDemo() {

    }

    private static SingletonDemo get() {
        if (singleton == null) {
            synchronized (SingletonDemo.class) {
                if (singleton == null) {
                    singleton = new SingletonDemo();
                }
            }
        }
        return singleton;
    }
}
