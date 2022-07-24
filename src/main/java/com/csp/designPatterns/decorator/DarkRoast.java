package com.csp.designPatterns.decorator;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/7/17
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "DarkRoast";
    }

    @Override
    public double cost() {
        return 2.99;
    }
}
