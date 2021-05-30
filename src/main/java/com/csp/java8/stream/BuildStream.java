package com.csp.java8.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @description: 构建流
 * @author: csp52872
 * @date: 2021/02/13
 */
public class BuildStream {
    public static void main(String[] args) {
        funcBuildStream();

        fibonacciSequeTuple();

        fibonacciSeque();
    }

    /**
     * 由值创建
     */
    public static void valueBuildStream() {
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);
        // 构建一个空流
        Stream<Object> empty = Stream.empty();
    }

    /**
     * 函数创建流
     */
    public static void funcBuildStream() {
        // 创建无限流，注意添加limit
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
        //
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    /**
     * 数组生成流
     */
    public static void ArrayBuildStream() {
        int[] numbers = {2, 3, 5, 7, 11, 13};
        System.out.println(Arrays.stream(numbers).sum());
    }

    /**
     * 文件生成流
     */
    public static long fileBuildStream() {
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("test.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uniqueWords;
    }

    /**
     * 斐波那契数列元祖
     * (0,1)
     * (1,1)
     * (1,2)
     * (2,3)
     * (3,5)
     * (5,8)
     */
    public static void fibonacciSequeTuple() {
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
    }

    /**
     * 斐波那契数列
     */
    public static void fibonacciSeque() {
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .map(t -> t[0])
                .limit(10)
                .forEach(System.out::println);
    }
}
