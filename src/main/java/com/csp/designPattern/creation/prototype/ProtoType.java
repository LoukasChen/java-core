package com.csp.designPattern.creation.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author csp
 * @date 2022/8/1
 */
public class ProtoType implements Cloneable {

    private List<String> list;

    public static void main(String[] args) throws CloneNotSupportedException {
        ProtoType protoType = new ProtoType();
        List<String> temp = new ArrayList<String>() {{
            add("1");
            add("2");
        }};
        protoType.setList(temp);
        // 浅拷贝
        ProtoType clone = protoType.clone();
        clone.getList().add("3");
        System.out.println(clone == protoType);
        System.out.println(clone.getClass() == protoType.getClass());
        System.out.println(clone.equals(protoType));
    }

    @Override
    public ProtoType clone() {
        try {
            return (ProtoType) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
