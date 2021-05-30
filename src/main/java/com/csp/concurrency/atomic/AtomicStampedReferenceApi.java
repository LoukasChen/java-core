package com.csp.concurrency.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @description: AtomicStampedReference通过引入版本号 解决CAS ABA问题
 * @author: csp52872
 * @date: 2021/05/30
 */
public class AtomicStampedReferenceApi {

    public static void main(String[] args) {
        User user = new User("user", 10);
        int stamp = 1;
        AtomicStampedReference<User> atomicStampedReference = new AtomicStampedReference<>(user, stamp);
        atomicStampedReference.compareAndSet(user, new User("user", 20), stamp, stamp + 1);
        System.out.println(atomicStampedReference.getReference());
    }

    static class User {

        private String name;

        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
