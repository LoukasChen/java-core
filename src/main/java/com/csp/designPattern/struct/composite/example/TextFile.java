package com.csp.designPattern.struct.composite.example;

/**
 * @author csp
 * @date 2022/9/18
 */
public class TextFile extends AbstractFile {

    private final String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    protected void add(AbstractFile file) {
        System.out.println("unsupported method");
    }

    @Override
    protected void remove(AbstractFile file) {
        System.out.println("unsupported method");
    }

    @Override
    protected AbstractFile getChild(int index) {
        System.out.println("unsupported method");
        return null;
    }

    @Override
    protected void killVirus() {
        System.out.println("对图片文件" + name + "进行杀毒");
    }
}
