package com.csp.concurrency.lock.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @description: 基于CAS实现一个简易的同步锁
 * @author: csp52872
 * @date: 2021/05/29
 */
public class MyLock implements Lock {
    /**
     * lockStatus为0表示无锁；
     * lockStatus为1表示锁被持有；
     */
    private AtomicInteger lockStatus = new AtomicInteger(0);

    /**
     * 状态如果为0，则更新为1；
     * 状态如果为1，说明该锁被其他线程持有中，当前线程让出执行权
     */
    public void lock() {
        while (!lockStatus.compareAndSet(0, 1)) {
            Thread.yield();
        }
    }

    /**
     * 状态如果为1，则更新为0
     */
    public void unlock() {
        lockStatus.compareAndSet(1, 0);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }

}
