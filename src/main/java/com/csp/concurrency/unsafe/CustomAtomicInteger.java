package com.csp.concurrency.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @desc: 自定义原子整数类
 * @author: csp52872
 * @date: 2021/11/7
 */
public class CustomAtomicInteger {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.increment(10);
        System.out.println(atomicInteger.getValue());
    }

    private static class AtomicInteger {

        private volatile int value;

        private static final long valueOffset;

        private static final Unsafe UNSAFE;

        static {
            try {
                Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                theUnsafe.setAccessible(true);
                UNSAFE = (Unsafe) theUnsafe.get(null);
                valueOffset = UNSAFE.objectFieldOffset(AtomicInteger.class.getDeclaredField("value"));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        public int getValue() {
            return value;
        }

        public void increment(int value) {
            while (true) {
                int prev = this.value;
                int next = prev + value;
                if (UNSAFE.compareAndSwapInt(this, valueOffset, prev, next)) {
                    break;
                }
            }
        }
    }
}
