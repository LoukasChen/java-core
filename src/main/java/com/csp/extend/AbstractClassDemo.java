package com.csp.extend;

/**
 * @description: 抽象类
 * @author: csp52872
 * @date: 2020/12/27
 */
public abstract class AbstractClassDemo implements InterfaceDemo {

    @Override
    public void addAll(int[] numbers) {
        for (int number : numbers) {
            add(number);
        }
    }
}


interface InterfaceDemo {

    void add(int number);

    void addAll(int[] numbers);
}
