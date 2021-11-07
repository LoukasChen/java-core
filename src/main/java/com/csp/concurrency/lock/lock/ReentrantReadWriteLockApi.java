package com.csp.concurrency.lock.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @desc: 读写锁
 * @author: csp52872
 * @date: 2021/11/7
 */
public class ReentrantReadWriteLockApi {
    /**
     * 读写锁
     */
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    /**
     * 读锁
     */
    private ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    /**
     * 写锁
     */
    private ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public static void main(String[] args) {
        ReentrantReadWriteLockApi lockApi = new ReentrantReadWriteLockApi();
        // 读锁之间，不会互斥，可重入
        new Thread(() -> lockApi.readLock()).start();
        new Thread(() -> lockApi.readLock()).start();

        // 读写锁之间，会互斥，不可重入
        new Thread(() -> lockApi.readLock()).start();
        new Thread(() -> lockApi.writeLock()).start();

        // 写锁之间，会互斥，不可重入
        new Thread(() -> lockApi.writeLock()).start();
        new Thread(() -> lockApi.writeLock()).start();
    }

    private void readLock() {
        readLock.lock();
        try {
            System.out.println("readLock");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            System.out.println("release read lock");
            readLock.unlock();
        }
    }

    private void writeLock() {
        writeLock.lock();
        try {
            System.out.println("writeLock");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            System.out.println("release write lock");
            writeLock.unlock();
        }
    }

}
