package com.csp.designPattern.struct.bridge;

/**
 * @author csp
 * @date 2022/9/17
 */
public class Client {

    public static void main(String[] args) {
        AbstractImage jpgImage = new JPGImage();
        jpgImage.setImageOSService(new LinuxImageImpl());
        jpgImage.parseFile("csp");
    }
}
