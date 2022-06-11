package com.csp.mapstruct;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/5/8
 */
public class Car {

    private String make;
    private int numberOfSeats;
    private Integer type;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
