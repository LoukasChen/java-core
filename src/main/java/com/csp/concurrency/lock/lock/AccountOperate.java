package com.csp.concurrency.lock.lock;

import java.util.Random;

/**
 * @description: 账户操作
 * @author: csp52872
 * @date: 2021/05/30
 */
public class AccountOperate {

    public static void main(String[] args) throws NoEnoughMoneyException {
        simulateTransfer();
    }

    public static void simulateTransfer() {
        final int accountNum = 10;
        final Account[] accounts = new Account[accountNum];
        final Random rnd = new Random();
        for (int i = 0; i < accountNum; i++) {
            accounts[i] = new Account(rnd.nextInt(10000));
        }
        int threadNum = 100;
        Thread[] threads = new Thread[threadNum];
        for (int i = 0; i < threadNum; i++) {
            threads[i] = new Thread(() -> {
                int loopNum = 100;
                for (int k = 0; k < loopNum; k++) {
                    int x = rnd.nextInt(accountNum);
                    int y = rnd.nextInt(accountNum);
                    int money = rnd.nextInt(10);
                    // 非同一个账户进行转账操作
                    if (x != y) {
                        try {
                            doTransfer(accounts[x], accounts[y], money);
                        } catch (NoEnoughMoneyException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            threads[i].start();
        }
    }

    public static void doTransfer(Account src, Account dest, double money) throws NoEnoughMoneyException {
        boolean success;
        do {
            success = tryLockTransfer(src, dest, money);
            if (!success) {
                Thread.yield();
            }
        } while (!success);
    }

    /**
     * tryLock 防止死锁
     *
     * @param src
     * @param dest
     * @param money
     * @return
     * @throws NoEnoughMoneyException
     */
    public static boolean tryLockTransfer(Account src, Account dest, double money) throws NoEnoughMoneyException {
        if (src.tryLock()) {
            try {
                if (dest.tryLock()) {
                    try {
                        if (src.getMoney() >= money) {
                            src.reduce(money);
                            dest.add(money);
                        } else {
                            throw new NoEnoughMoneyException("账户余额不足");
                        }
                        return true;
                    } finally {
                        dest.unlock();
                    }
                }
            } finally {
                src.unlock();
            }
        }
        return false;
    }

    /**
     * 转账死锁
     *
     * @param src
     * @param dest
     * @param money
     * @return
     * @throws NoEnoughMoneyException
     */
    public static boolean transferDeadlock(Account src, Account dest, double money) throws NoEnoughMoneyException {
        src.lock();
        try {
            try {
                dest.lock();
                if (src.getMoney() >= money) {
                    src.reduce(money);
                    dest.add(money);
                } else {
                    throw new NoEnoughMoneyException("账户余额不足");
                }
            } finally {
                dest.unlock();
            }
        } finally {
            src.unlock();
        }
        return false;
    }

    static class NoEnoughMoneyException extends Exception {

        public NoEnoughMoneyException(String message) {
            super(message);
        }
    }
}
