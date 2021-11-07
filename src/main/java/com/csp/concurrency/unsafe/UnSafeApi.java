package com.csp.concurrency.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @desc: Unsafe类
 * @author: csp52872
 * @date: 2021/11/7
 */
public class UnSafeApi {

    public static void main(String[] args) throws Exception {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        // 静态字段
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);

        // 获取域的偏移地址
        long idOffset = unsafe.objectFieldOffset(User.class.getDeclaredField("id"));
        long nameOffset = unsafe.objectFieldOffset(User.class.getDeclaredField("name"));

        User user = new User();
        // 比较并交换基本类型int
        unsafe.compareAndSwapInt(user, idOffset, 0, 1);
        // 比较并交换引用类型
        unsafe.compareAndSwapObject(user, nameOffset, null, "csp");

        System.out.println(user);
    }

    private static class User {

        public volatile int id;

        public volatile String name;

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
