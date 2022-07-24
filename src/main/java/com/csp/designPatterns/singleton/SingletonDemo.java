package com.csp.designPatterns.singleton;

import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author csp
 * @description: 单例实现
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

    private static final AtomicBoolean instantiate = new AtomicBoolean(false);

    /**
     * 防止反射创建
     */
    private SingletonDemo() {
        if (instantiate.compareAndSet(false, true)) {
            return;
        }
        throw new RuntimeException("current class already be instantiate");
    }

    /**
     * double check
     */
    private static SingletonDemo getInstance() {
        if (singleton == null) {
            synchronized (SingletonDemo.class) {
                if (singleton == null) {
                    singleton = new SingletonDemo();
                }
            }
        }
        return singleton;
    }

    /**
     * 防止克隆对象
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return singleton;
    }

    /**
     * 防止反序列化破坏
     *
     * @return
     */
    private Object readResolve() {
        return singleton;
    }

    public static void main(String[] args) throws Exception {
        SingletonDemo.getInstance();

        Constructor<SingletonDemo> declaredConstructor = SingletonDemo.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        SingletonDemo singletonDemo = declaredConstructor.newInstance();
    }
}
