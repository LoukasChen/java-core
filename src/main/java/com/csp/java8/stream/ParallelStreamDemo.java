package com.csp.java8.stream;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @description: 并行流处理任务
 * @author: csp52872
 * @date: 2020/12/31
 */
public class ParallelStreamDemo {

    public static void main(String[] args) throws Exception {
        parallelForEach();
        parallelSum();
        parallelSum(10);
        parallelAndSequential();
    }

    public static void parallelForEach() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        list.parallelStream().forEach(System.out::println);
    }

    public static void parallelSum(long n) {
        Long sum = Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
        System.out.println(sum);
    }

    public static void parallelSum() {
        Instant now = Instant.now();
        LongStream.rangeClosed(0, 10000000000L).reduce(0, Long::sum);
        System.out.println(Duration.between(now, Instant.now()).toMillis());
        System.out.println("-------------------");
        Instant now1 = Instant.now();
        LongStream.rangeClosed(0, 10000000000L).parallel().reduce(0, Long::sum);
        System.out.println(Duration.between(now1, Instant.now()).toMillis());
    }

    public static void parallelAndSequential() {
        Integer sum = Stream.of("1", "2", "3")
                .parallel() // 开启并行流
                .filter(i -> !"1".equals(i))
                .sequential() // 恢复顺序流
                .map(Integer::valueOf)
                .parallel() // 开启并行流
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
