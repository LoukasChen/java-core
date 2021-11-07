package com.csp.concurrency.lock.synchronize;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/10/18
 */
public abstract class SynchronizedAPI {

    public static void main(String[] args) throws InterruptedException {
        SyncObject syncObject = new SyncObject();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                syncObject.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                syncObject.decrement();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(syncObject.getCount());
    }

    private static class SyncObject {

        private int count;

//        public void increment() {
//            synchronized (this) {
//                count++;
//            }
//        }

        public synchronized void increment() {
            count++;
        }

//        public void decrement() {
//            synchronized (this) {
//                count--;
//            }
//        }

        public synchronized void decrement() {
            count--;
        }

        public int getCount() {
            return this.count;
        }
    }

    private static class SyncClass {
        private static int count;

//        public static void increment() {
//            synchronized (SyncClass.class) {
//                count++;
//            }
//        }

        public static synchronized void increment() {
            count++;
        }

//        public static void decrement() {
//            synchronized (SyncClass.class) {
//                count++;
//            }
//        }

        public static synchronized void decrement() {
            count++;
        }

    }

}



