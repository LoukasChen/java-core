package com.csp.concurrency.threadpool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @desc: 自定义线程池
 * @author: csp52872
 * @date: 2021/11/6
 */
public class CustomThreadPool {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(3, 1000, TimeUnit.MICROSECONDS, 10,
                // 无限等待
//                (queue, task) -> queue.put(task)
                // 带超时时间
//                ((taskQueue, task) -> taskQueue.offer(task, 1, TimeUnit.SECONDS))
                // 调用者什么都不做
//                (taskQueue, task) -> System.out.println()
                // 抛出异常
//                (taskQueue, task) -> new RuntimeException("")
                // 调用者自己执行
                (taskQueue, task) -> task.run()
        );
        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }


    private static class ThreadPool {
        /**
         * 阻塞队列
         */
        private BlockingQueue<Runnable> taskQueue;

        private HashSet<Worker> workers = new HashSet<>();
        /**
         * 核心线程数
         */
        private int coreSize;
        /**
         * 超时时间
         */
        private long timeout;

        private TimeUnit timeUnit;

        private RejectedPolicy<Runnable> rejectedPolicy;

        public ThreadPool(int coreSize, long timeout, TimeUnit timeUnit, int queueCapacity, RejectedPolicy<Runnable> rejectedPolicy) {
            this.coreSize = coreSize;
            this.timeout = timeout;
            this.timeUnit = timeUnit;
            this.taskQueue = new BlockingQueue<>(queueCapacity);
            this.rejectedPolicy = rejectedPolicy;
        }

        /**
         * 线程池执行
         */
        public void execute(Runnable task) {
            synchronized (workers) {
                if (workers.size() < coreSize) {
                    Worker worker = new Worker(task);
                    System.out.println("创建一个worker");
                    workers.add(worker);
                    worker.start();
                } else {
                    System.out.println("任务放入阻塞队列");
                    taskQueue.putWithRejectedPolicy(this.rejectedPolicy, task);
                }
            }
        }

        private class Worker extends Thread {

            private Runnable task;

            public Worker(Runnable task) {
                this.task = task;
            }

            @Override
            public void run() {
                // 当task任务不为空，或者队列还有任务，则继续执行
                while (task != null || (task = taskQueue.poll(timeout, timeUnit)) != null) {
                    try {
                        System.out.println("执行任务");
                        task.run();
                    } finally {
                        task = null;
                    }
                }
                synchronized (workers) {
                    System.out.println("任务执行完");
                    workers.remove(this);
                }
            }
        }
    }

    private static class BlockingQueue<T> {
        /**
         * 队列
         */
        private Deque<T> queue = new ArrayDeque<>();
        /**
         * 锁
         */
        private ReentrantLock lock = new ReentrantLock();
        /**
         * 池满的生产者等待条件
         */
        private Condition fullWaitSet = lock.newCondition();
        /**
         * 池空的消费者等待条件
         */
        private Condition emptyWaitSet = lock.newCondition();

        /**
         * 容量
         */
        private int capacity;

        public BlockingQueue(int capacity) {
            this.capacity = capacity;
        }

        /**
         * 带超时时间的拉取
         *
         * @param timeout
         * @param timeUnit
         * @return
         */
        public T poll(long timeout, TimeUnit timeUnit) {
            lock.lock();
            try {
                // 转换为纳秒
                long nanos = timeUnit.toNanos(timeout);
                while (queue.isEmpty()) {
                    try {
                        if (nanos <= 0) {
                            return null;
                        }
                        // 返回的是剩余时间
                        nanos = emptyWaitSet.awaitNanos(nanos);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                T t = queue.removeFirst();
                fullWaitSet.signal();
                return t;
            } finally {
                lock.unlock();
            }
        }

        /**
         * 从队列里面取数据
         *
         * @return
         */
        public T take() {
            lock.lock();
            try {
                while (queue.isEmpty()) {
                    try {
                        emptyWaitSet.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                T t = queue.removeFirst();
                fullWaitSet.signal();
                return t;
            } finally {
                lock.unlock();
            }
        }

        /**
         * 往队列放数据
         *
         * @param element
         */
        public void put(T element) {
            lock.lock();
            try {
                while (queue.size() == capacity) {
                    try {
                        fullWaitSet.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.addLast(element);
                emptyWaitSet.signal();
            } finally {
                lock.unlock();
            }
        }

        /**
         * @param rejectedPolicy
         * @param task
         */
        public void putWithRejectedPolicy(RejectedPolicy<T> rejectedPolicy, T task) {
            lock.lock();
            try {
                while (queue.size() == capacity) {
                    rejectedPolicy.reject(this, task);
                }
                queue.addLast(task);
                emptyWaitSet.signal();
            } finally {
                lock.unlock();
            }
        }

        public void offer(T element, long timeout, TimeUnit timeUnit) {
            lock.lock();
            long nanos = timeUnit.toNanos(timeout);
            try {
                while (queue.size() == capacity) {
                    try {
                        if (nanos <= 0) {
                            return;
                        }
                        nanos = fullWaitSet.awaitNanos(nanos);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.addLast(element);
                emptyWaitSet.signal();
            } finally {
                lock.unlock();
            }
        }

        public int size() {
            lock.lock();
            try {
                return queue.size();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 拒绝策略接口
     *
     * @param <T>
     */
    @FunctionalInterface
    public interface RejectedPolicy<T> {

        void reject(BlockingQueue<T> taskQueue, T task);

    }

}

