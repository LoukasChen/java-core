package com.csp.java8.stream;

import com.csp.java8.object.Dish;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: 收集器Collectors
 * @author: csp52872
 * @date: 2021/03/14
 */
public class CollectorDemo {

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
                new Dish("salmon", false, 300, Dish.Type.FISH));
    }


    public static void main(String[] args) {
        toList();
        toSet();
        count();
        reducing();
        toCollection();
        toMap();
        joining();
        groupBy();
        groupByAndGetMaxOrMin();
        groupByCount();
        groupByToMap();
        groupByThenSortAndFilter();
        partitionBy();
        groupByThenPartitioningBy();
    }

    public static void toList() {
        List<Integer> list = Stream.of(3, 1, 2, 3).sorted().collect(Collectors.toList());
        System.out.println(list);
    }

    public static void toSet() {
        Set<Integer> set = Stream.of(3, 1, 2, 3).collect(Collectors.toSet());
        System.out.println(set);
    }

    public static void count() {
        Long count = Stream.of(1, 2, 3).collect(Collectors.counting());
        System.out.println(count);
    }

    public static void toCollection() {
        LinkedHashSet<Integer> linkedHashSet = Stream.of(3, 1, 2, 3).collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(linkedHashSet);
    }

    public static void toMap() {
        Map<String, Integer> map = menuList.stream().collect(Collectors.toMap(Dish::getName, Dish::getCalories));
        System.out.println(map);

        try {
            // 以calories为key，Dish为value，缺点是key不能重复，如果重复程序会报错
            Map<Integer, Dish> map1 = menuList.stream().collect(Collectors.toMap(Dish::getCalories, Function.identity()));
            System.out.println(map1);
        } catch (Exception e) {
        }

        // 合并重复的key，我这里只输出了第一个key，忽略第二个key
        Map<Integer, Dish> map2 = menuList.stream().collect(Collectors.toMap(Dish::getCalories, Function.identity(), (calories1, calories2) -> calories1));
        System.out.println(map2);

        // 定义Map的实现类为TreeMap，进行排序
        TreeMap<Integer, Dish> map3 = menuList.stream().collect(Collectors.toMap(Dish::getCalories, Function.identity(), (calories1, calories2) -> calories1, TreeMap::new));
        System.out.println(map3);

        // concurrentMap
        ConcurrentMap<Integer, Dish> concurrentMap = menuList.stream().collect(Collectors.toConcurrentMap(Dish::getCalories, Function.identity(), (calories1, calories2) -> calories1));
    }

    public static void reducing() {
        Integer reduce = menuList.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
        // 等同于如下语句
        // menuList.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(reduce);

        Optional<Dish> reducingOptional = menuList.stream().collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println(reducingOptional.get());
    }

    public static void joining() {
        // 直接拼接
        Stream.of("java", "scala", "go").collect(Collectors.joining()); // javascalago
        // 以逗号分隔，首位添加[]
        String join = Stream.of("java", "scala", "go").collect(Collectors.joining(",", "[", "]"));
        System.out.println(join);
    }

    public static void groupBy() {
        Map<Dish.Type, List<Dish>> groupByType = menuList.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(groupByType);

        Map<Dish.Type, Long> groupingByCounting = menuList.stream().collect(Collectors.groupingBy(Dish::getType, LinkedHashMap::new, Collectors.counting()));
        System.out.println(groupingByCounting);

    }

    /**
     * 分组统计最大最小值
     */
    public static void groupByAndGetMaxOrMin() {
        Map<Dish.Type, Optional<Dish>> groupingByMaxBy = menuList.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(groupingByMaxBy);

        Map<Dish.Type, Optional<Dish>> groupingByMinBy = menuList.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.minBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(groupingByMinBy);

        Map<Dish.Type, Dish> groupByAndGet = menuList.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(groupByAndGet);
    }

    /**
     * 分组统计数值（平均值、累加值）
     */
    public static void groupByCount() {
        Map<Dish.Type, Double> averagingDouble = menuList.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.averagingDouble(Dish::getCalories)));
        System.out.println(averagingDouble);

        Map<Dish.Type, Integer> summingInt = menuList.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.summingInt(Dish::getCalories)));
        System.out.println(summingInt);

        Map<Dish.Type, LongSummaryStatistics> summarizingLong = menuList.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.summarizingLong(Dish::getCalories)));
        System.out.println(summarizingLong);
    }

    public static void groupByToMap() {
        Map<Dish.Type, List<String>> groupByToMap = menuList.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(Dish::getName, Collectors.toList())));
        System.out.println(groupByToMap);
    }

    /**
     *
     */
    public static void groupByThenSortAndFilter() {
        Map<Dish.Type, List<Dish>> groupByAndSort = menuList.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.collectingAndThen(Collectors.toList(), r -> {
            r.sort(Comparator.comparing(Dish::getCalories).reversed());
            return r;
        })));
        System.out.println(groupByAndSort);

        Map<Dish.Type, List<Dish>> groupByAndFilter = menuList.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.collectingAndThen(Collectors.toList(), r -> r.stream().filter(cal -> cal.getCalories() > 600).collect(Collectors.toList()))));
        System.out.println(groupByAndFilter);
    }

    /**
     * 分成两个区，true or false
     */
    public static void partitionBy() {
        Map<Boolean, List<Dish>> partitioningBy = menuList.stream().collect(Collectors.partitioningBy(t -> t.getCalories() > 600));
        System.out.println(partitioningBy);

        Map<Boolean, Double> partitioningByAndGetAveragingDouble = menuList.stream().collect(Collectors.partitioningBy(t -> t.getCalories() > 600, Collectors.averagingDouble(Dish::getCalories)));
        System.out.println(partitioningByAndGetAveragingDouble);
    }

    /**
     * groupBy和PartitioningBy相互嵌套
     */
    public static void groupByThenPartitioningBy() {
        Map<Dish.Type, Map<Boolean, List<Dish>>> groupByCombinePartitioningBy = menuList.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.partitioningBy(t -> t.getCalories() > 600)));
        System.out.println(groupByCombinePartitioningBy);
    }

}
