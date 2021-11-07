package com.csp.concurrency.lock.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/11/1
 */
public class ReentrantLockAPI {

    private final Lock lock = new ReentrantLock();

    private volatile boolean flag = false;

    private Condition condition = lock.newCondition();

    public static void main(String[] args) {
        ReentrantLockAPI reentrantLock = new ReentrantLockAPI();
//        Thread thread = new Thread(() -> reentrantLock.lockInterruptibly());
//        reentrantLock.lock.lock();
//        thread.start();
//        thread.interrupt();

        Thread thread = new Thread(reentrantLock::conditionAwait);
        thread.start();
        reentrantLock.conditionSignal();
    }

    private void lockInterruptibly() {
        try {
            System.out.println("尝试获取锁");
            lock.lockInterruptibly();
            System.out.println("成功获得锁");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("中断线程");
        } finally {
            lock.unlock();
        }
    }

    private void conditionAwait() {
        try {
            lock.lock();
            try {
                System.out.println("await before");
                while (!flag) {
                    condition.await();
                }
                System.out.println("await after");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }

    private void conditionSignal() {
        try {
            lock.lock();
            this.flag = true;
            TimeUnit.SECONDS.sleep(1);
            condition.signal();
            System.out.println("signal after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
