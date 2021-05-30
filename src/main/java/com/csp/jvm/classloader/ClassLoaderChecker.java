package com.csp.jvm.classloader;

/**
 * @author csp
 * @description: TODO
 * @date 2019/9/28 16:22
 */
public class ClassLoaderChecker {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader("C:\\Users\\csp\\Desktop\\","myClassLoader");
        Class<?> aClass = myClassLoader.findClass("defineMyClassLoader");
        System.out.println(aClass.getClassLoader());
        Object o = aClass.newInstance();
    }
}
