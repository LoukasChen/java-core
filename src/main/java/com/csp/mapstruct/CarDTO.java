package com.csp.mapstruct;

import java.util.StringJoiner;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/5/8
 */
public class CarDTO {

    private String make;

    private int seatCount;

    private String type;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CarDTO.class.getSimpleName() + "[", "]")
                .add("make='" + make + "'")
                .add("seatCount=" + seatCount)
                .add("type='" + type + "'")
                .toString();
    }
}
