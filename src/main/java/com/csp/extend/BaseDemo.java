package com.csp.extend;

/**
 * @description:
 * @author: csp52872
 * @date: 2020/12/27
 */
public class BaseDemo extends AbstractClassDemo {

    private int[] arr = new int[10];

    private int count;

    public static void main(String[] args) {
        BaseDemo baseDemo = new BaseDemo();
        baseDemo.addAll(new int[]{1, 2, 3});
    }


    @Override
    public void add(int number) {
        arr[count++] = number;
    }
}
