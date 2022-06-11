package com.csp.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/4/17
 */
public class Test<T extends Number & Comparable<?> & Iterable<?>> {

//    private static T ins;

    public static void main(String[] args) {
        List<? extends Number> numbers = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        integers.toArray();
        numbers = integers;

//        array();
        generic();
        Set<Integer> set1 = new HashSet<Integer>() {{
            add(1);
        }};
        Set<Double> set2 = new HashSet<Double>() {{
            add(1D);
        }};
        Set<? extends Number> union = union(set1, set2);
    }

    public static void array() {
        Number[] numbers = new Integer[1];
        numbers[0] = 1.0D;
    }

    public static void generic() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1});
        System.out.println(list);
    }

    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        return new HashSet<>();
    }

    /**
     * 协变
     */
    public void covariant() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        List<? extends Number> numbers = new ArrayList<Integer>();
//        numbers.add(new Integer(1));
//        numbers.add(new Double(1.0D));

        Number number = numbers.get(0);
//        Integer integer = numbers.get(0);
    }

    /**
     * 逆变
     */
    public void contravariant() {
        List<? super Number> nums = new ArrayList<Object>();
        nums.add(new Integer(1));
        nums.add(new Double(1D));
        Object object = nums.get(0);
        addAll(nums);
    }


    public void addAll(List<? super Integer> list) {
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
    }
}
