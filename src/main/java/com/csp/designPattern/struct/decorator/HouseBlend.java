package com.csp.designPattern.struct.decorator;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/7/17
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
