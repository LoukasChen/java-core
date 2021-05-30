package com.csp.java8.stream;

import com.csp.java8.object.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/02/13
 */
public class PrimitiveStream {

    private static List<Dish> menuList = null;

    static {
        menuList = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
    }

    public static void main(String[] args) {

    }

    /**
     * 映射到数值流
     *
     * @return
     */
    public static int sumCalories() {
        return menuList.stream()
                .mapToInt(Dish::getCalories) // 返回IntStream
                .sum();
    }

    /**
     * 转换为对象流
     */
    public static void convertObjectStream() {
        IntStream intStream = menuList.stream().mapToInt(Dish::getCalories);
        Stream<Integer> boxed = intStream.boxed();
    }

    /**
     * 默认值OptionalInt
     */
    public static void optionalInt() {
        OptionalInt optionalInt = menuList.stream()
                .mapToInt(Dish::getCalories)
                .max();
        int max = optionalInt.orElse(1);
    }

    /**
     * 数值范围
     */
    public static void numberRange() {
        IntStream intStream = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        System.out.println(intStream.count());
    }

//    public static void ee() {
//        IntStream.rangeClosed(1,100)
//                .filter((a,b) -> Math.sqrt(a*a+b*b) % 1 == 0)
//
//    }

}
