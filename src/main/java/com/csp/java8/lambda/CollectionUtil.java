package com.csp.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author: csp52872
 * @date: 2021/02/09
 */
public class CollectionUtil {

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> arrayList = new ArrayList<>();
        list.forEach(l -> {
            if (predicate.test(l)) {
                arrayList.add(l);
            }
        });
        return arrayList;
    }

    public static <T> void foreach(List<T> list, Consumer<T> consumer) {
        list.forEach(consumer);
    }

    public static <T, R> List<R> collect(List<T> list, Function<T, R> function) {
        List<R> arrayList = new ArrayList<>();
        list.forEach(t -> arrayList.add(function.apply(t)));
        return arrayList;
    }

    public static <T> List<T> collect(List<T> list, Supplier<T> supplier) {
        List<T> arrayList = new ArrayList<>();
        list.forEach(t -> arrayList.add(supplier.get()));
        return arrayList;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);

        List<Integer> filteredList = CollectionUtil.filter(list, predicate -> !predicate.equals(2));
        System.out.println(filteredList);

        CollectionUtil.foreach(list, System.out::println);

        List<Double> collectedList = CollectionUtil.collect(list, Integer::doubleValue);
        System.out.println(collectedList);

        List<Integer> collectList = CollectionUtil.collect(list, list::size);
        System.out.println(collectList);

        Runnable runnable = System.out::println;
        runnable.run();
    }

}
