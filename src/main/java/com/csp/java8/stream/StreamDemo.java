package com.csp.java8.stream;

import com.csp.java8.object.Dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/02/12
 */
public class StreamDemo {

    private static final List<Integer> numberList = Arrays.asList(1, 2, 3, 4);

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
        System.out.println(getMenuNameList());

        System.out.println(getDishTypeMeatList());

        System.out.println(getWordsLength());

        System.out.println(distinctWords());

        System.out.println(intSquareList());

        System.out.println(intCompositeList());

        System.out.println(intCompositeFilterList());

        find();

        match();

        reduce();

        System.out.println(peek());
    }


    public static List<String> getMenuNameList() {
        return menuList.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    public static List<Dish> getDishTypeMeatList() {
        return menuList.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());
    }

    /**
     * 获取单词长度
     *
     * @return
     */
    public static List<Integer> getWordsLength() {
        return menuList.stream()
                .map(dish -> dish.getName())
                .map(String::length)
                .collect(Collectors.toList());
    }

    /**
     * 对单词进行去重
     *
     * @return
     */
    public static List<String> distinctWords() {
        Stream<String> stream = Arrays.stream(new String[]{"Hello", "World"});
        List<String> list = Arrays.asList("Hello", "World");
        List<String> distinctWordsList = list.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        return distinctWordsList;
    }

    /**
     * 计算整数的平方
     *
     * @return
     */
    public static List<Integer> intSquareList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> integerList = list.stream()
                .map(i -> i * i)
                .collect(Collectors.toList());
        return integerList;
    }

    /**
     * 组合List成数对
     *
     * @return
     */
    public static List<int[]> intCompositeList() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);
        return list1.stream()
                .flatMap(i -> list2.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
    }

    /**
     * 返回数对之和能够被3整除的数对
     *
     * @return
     */
    public static List<int[]> intCompositeFilterList() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);
        return list1.stream()
                .flatMap(i -> list2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
    }

    public static void match() {
        if (menuList.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("dish isVegetarian");
        }
        if (menuList.stream().allMatch(dish -> dish.getCalories() < 1000)) {
            System.out.println("dish calories < 100");
        }
        if (menuList.stream().noneMatch(dish -> dish.getCalories() >= 1000)) {
            System.out.println("dish calories > 1000");
        }
    }

    public static void find() {
        menuList.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish -> System.out.println(dish.getName()));

        numberList.stream()
                .map(i -> i * i)
                .filter(i -> i % 3 == 0)
                .findFirst()
                .ifPresent(System.out::println);
    }

    public static void reduce() {
        Integer add = numberList.stream().reduce(0, Integer::sum);
        System.out.println(add);

        Integer reduce = numberList.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        numberList.stream().reduce(Integer::sum).ifPresent(System.out::println);

        numberList.stream().reduce(Integer::max).ifPresent(System.out::println);

        numberList.stream().reduce(Integer::min).ifPresent(System.out::println);

        // 利用map-reduce统计菜单中有多个菜
        menuList.stream().map(dish -> 1).reduce(Integer::sum).ifPresent(System.out::println);
        // 利用count统计菜单中有多个菜
        long count = menuList.stream().count();
    }

    public static List<String> peek() {
        return menuList.stream()
                .filter(Dish::isVegetarian)
                .peek(e -> System.out.println("menu filter:" + e))
                .map(Dish::getName)
                .peek(e -> System.out.println("menu getName:" + e))
                .collect(Collectors.toList());

    }
}
