package com.csp.designPatterns.singleton;

/**
 * @author csp
 * @description: 静态内部类实现线程安全的单例模式
 * @date 2019/10/8 21:48
 */
public class SingletonStaticInner {

    private SingletonStaticInner() {
    }

    private static class SingletonHolder {

        private static final SingletonStaticInner INSTANCE = new SingletonStaticInner();
    }

    public static SingletonStaticInner getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }

}
