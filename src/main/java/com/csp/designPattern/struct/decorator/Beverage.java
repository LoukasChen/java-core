package com.csp.designPattern.struct.decorator;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/7/17
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

}
