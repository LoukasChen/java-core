package com.csp.concurrency.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @desc: 原子引用字段更新器
 * @author: csp52872
 * @date: 2021/11/6
 */
public class AtomicReferenceFieldUpdaterApi {

    private AtomicReferenceFieldUpdater updater = AtomicReferenceFieldUpdater.newUpdater(User.class, String.class, "name");

    public static void main(String[] args) {
        AtomicReferenceFieldUpdaterApi api = new AtomicReferenceFieldUpdaterApi();
        User user = new User();
        System.out.println(api.compareAndSet(user));
        System.out.println(user);
    }

    private boolean compareAndSet(User user) {
        return this.updater.compareAndSet(user, null, "stu");
    }

    private static class User {

        private volatile String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
