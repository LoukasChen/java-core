package com.csp.designPattern.struct.bridge;

/**
 * @author csp
 * @date 2022/9/17
 */
public class WindowsImageImpl implements ImageOSService {
    @Override
    public void doPaint() {
        System.out.println("doPaint at windows...");
    }
}
