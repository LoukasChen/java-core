package com.csp.java8.lambda;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author: csp
 * @date: 2020/03/14
 */
public class TestImpl implements Test<String> {

    public TestImpl() {

    }

    public TestImpl(Integer integer) {

    }


    @Override
    public void eat(String s) {

    }


    public static void main(String[] args) {
        Supplier<TestImpl> supplier = TestImpl::new;
        TestImpl test = supplier.get();

        Function<Integer, TestImpl> function = new Function<Integer, TestImpl>() {
            @Override
            public TestImpl apply(Integer integer) {
                return new TestImpl(integer);
            }
        };
        Function<Integer, TestImpl> function1 = TestImpl::new;
        TestImpl apply = function1.apply(1);

        String[] arr = new String[]{"tf", "fd", "qd"};
        Arrays.sort(arr, TestImpl::compare);
        Arrays.sort(arr, String::compareTo);
        System.out.println(String.join("-", arr));
    }

    private static int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
}
