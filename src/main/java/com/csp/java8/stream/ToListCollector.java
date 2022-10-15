package com.csp.java8.stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * 自定义收集器
 *
 * @author csp
 * @date 2022/10/5
 */
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(
                Characteristics.IDENTITY_FINISH,
                Characteristics.CONCURRENT));
    }

    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2, 3).collect(new ToListCollector<>());
        System.out.println(list);

        List<Integer> collect = Stream.of(2, 3, 4).collect(ArrayList::new, List::add, List::addAll);
        System.out.println(collect);
    }
}
