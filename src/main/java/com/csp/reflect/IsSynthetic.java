package com.csp.reflect;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * @desc: 是否为合成字段
 * @author: csp52872
 * @date: 2021/08/11
 */
public class IsSynthetic {

    public static void main(String[] args) throws Exception {
        Class<Foo> fooClass = Foo.class;
        Constructor<Foo> constructor = fooClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Foo foo = constructor.newInstance();

//        Foo foo = fooClass.newInstance();

        Class<Foo.Bar> clazz = Foo.Bar.class;
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(field.getModifiers());
            System.out.println(field.getModifiers() & 0x00001000);
            System.out.println(Modifier.toString(field.getModifiers()));
            System.out.println("name:" + field.getName() + ",isSynthetic:" + field.isSynthetic());
        }

        Arrays.stream(clazz.getDeclaredMethods()).allMatch(Method::isBridge);
    }
}
