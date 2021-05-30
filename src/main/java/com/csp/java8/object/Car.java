package com.csp.java8.object;

import java.util.Optional;

/**
 * @author: csp52872
 * @date: 2021/02/10
 */
public class Car {

    private Insurance insurance;

    public Optional<Insurance> getInsurance() {
        return Optional.ofNullable(insurance);
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
}
