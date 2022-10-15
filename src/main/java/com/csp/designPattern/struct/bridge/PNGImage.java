package com.csp.designPattern.struct.bridge;

/**
 * @author csp
 * @date 2022/9/17
 */
public class PNGImage extends AbstractImage {

    @Override
    public void parseFile(String fileName) {
        super.imageOSService.doPaint();
        System.out.println(fileName + "格式为PNG");
    }
}
