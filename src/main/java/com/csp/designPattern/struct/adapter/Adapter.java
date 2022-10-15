package com.csp.designPattern.struct.adapter;

/**
 * @author csp
 * @date 2022/8/25
 */
public class Adapter implements Target {

    private final Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specialRequest();
    }
}
