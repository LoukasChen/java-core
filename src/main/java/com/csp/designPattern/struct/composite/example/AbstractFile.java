package com.csp.designPattern.struct.composite.example;

/**
 * 抽象文件类
 * @author csp
 * @date 2022/9/18
 */
public abstract class AbstractFile {

    protected abstract void add(AbstractFile file);

    protected abstract void remove(AbstractFile file);

    protected abstract AbstractFile getChild(int index);

    protected abstract void killVirus();
}
