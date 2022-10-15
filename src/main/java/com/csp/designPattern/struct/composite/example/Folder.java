package com.csp.designPattern.struct.composite.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author csp
 * @date 2022/9/18
 */
public class Folder extends AbstractFile {

    private final List<AbstractFile> list = new ArrayList<>();

    private final String name;

    public Folder(String name) {
        this.name = name;
    }

    @Override
    protected void add(AbstractFile file) {
        list.add(file);
    }

    @Override
    protected void remove(AbstractFile file) {
        list.add(file);
    }

    @Override
    protected AbstractFile getChild(int index) {
        return list.get(index);
    }

    @Override
    protected void killVirus() {
        System.out.println("对文件夹" + name + "进行杀毒");

        for (AbstractFile file : list) {
            file.killVirus();
        }
    }
}
