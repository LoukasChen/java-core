package com.csp.concurrency.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/11/6
 */
public class AQSTest {

    public static void main(String[] args) {
        Mutex lock = new Mutex();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("lock1");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("lock2");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        }).start();
    }

    private static class Mutex implements Lock {

        private Sync sync = new Sync();

        /**
         * 自定义不可重入锁
         */
        private static class Sync extends AbstractQueuedSynchronizer {

            @Override
            protected boolean tryAcquire(int arg) {
                if (super.compareAndSetState(0, 1)) {
                    super.setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
                return false;
            }

            @Override
            protected boolean tryRelease(int arg) {
//                if (!super.isHeldExclusively()) {
//                    throw new IllegalMonitorStateException();
//                }
                setExclusiveOwnerThread(null);
                // 这里将setExclusiveOwnerThread 放在setState之前
                // 是因为state是volatile修饰的，可以保证写屏障之前的操作同步到主存
                super.setState(0);
                return true;
            }

            /**
             * 是否持有独占锁
             *
             * @return
             */
            @Override
            protected boolean isHeldExclusively() {
                return super.getExclusiveOwnerThread() == Thread.currentThread();
            }

            public Condition newCondition() {
                return new ConditionObject();
            }
        }

        @Override
        public void lock() {
            sync.acquire(1);
        }

        @Override
        public void lockInterruptibly() throws InterruptedException {
            sync.acquireInterruptibly(1);
        }

        @Override
        public boolean tryLock() {
            return sync.tryAcquire(1);
        }

        @Override
        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
            return sync.tryAcquireNanos(1, unit.toNanos(time));
        }

        @Override
        public void unlock() {
            sync.release(1);
        }

        @Override
        public Condition newCondition() {
            return sync.newCondition();
        }

    }
}
