package com.csp.concurrency.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/03/27
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private final long[] numbers;

    private final int start;

    private final int end;

    public static final long THRESHOLD = 1000L;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    public ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length < THRESHOLD) {
            return computeSequentially();
        }
        int middle = start + length / 2;
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, middle);
        // 异步线程执行此任务
        leftTask.fork();
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, middle, end);
        // 递归执行任务
        Long rightResult = rightTask.compute();
        // 阻塞并拿到任务的最终结果
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    /**
     * 顺序求和
     */
    private long computeSequentially() {
        long sum = 0L;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        long[] array = LongStream.rangeClosed(1, 10000).toArray();
        ForkJoinTask<Long> forkJoinTask = new ForkJoinSumCalculator(array);
        System.out.println(new ForkJoinPool().invoke(forkJoinTask));
    }

}
