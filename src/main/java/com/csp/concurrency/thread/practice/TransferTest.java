package com.csp.concurrency.thread.practice;

import java.util.Random;

/**
 * @desc: 转账
 * @author: csp52872
 * @date: 2021/10/24
 */
public class TransferTest {

    public static void main(String[] args) throws Exception {
        Account account1 = new Account(1000);
        Account account2 = new Account(1000);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account1.transfer(account2, new Random().nextInt(100) + 1);
            }
        }
        );
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account2.transfer(account1, new Random().nextInt(100) + 1);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(account1.getMoney() + account2.getMoney());
    }

    private static class Account {

        private long money;

        public Account(long money) {
            this.money = money;
        }

        public long getMoney() {
            return money;
        }

        public void setMoney(long money) {
            this.money = money;
        }

        public void transfer(Account account, long amount) {
            synchronized (Account.class) {
                if (this.money < amount) {
                    return;
                }
                this.setMoney(this.getMoney() - amount);
                account.setMoney(account.getMoney() + amount);
            }
        }
    }
}
