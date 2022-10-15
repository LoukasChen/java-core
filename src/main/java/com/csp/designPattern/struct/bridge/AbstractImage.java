package com.csp.designPattern.struct.bridge;

/**
 * @author csp
 * @date 2022/9/17
 */
public abstract class AbstractImage {
    /**
     * 组合方式引入接口熟悉，供子类动态设置
     */
    protected ImageOSService imageOSService;

    public void setImageOSService(ImageOSService imageOSService) {
        this.imageOSService = imageOSService;
    }

    public abstract void parseFile(String fileName);

}
