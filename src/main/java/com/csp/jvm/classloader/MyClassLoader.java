package com.csp.jvm.classloader;

import java.io.*;

/**
 * @author csp
 * @description: 自定义ClassLoader
 * @date 2019/9/28 16:10
 */
public class MyClassLoader extends ClassLoader {

    private String path;
    private String classLoaderName;

    public MyClassLoader(String path, String classLoaderName) {
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

    /**
     * 用于寻找类文件
     *
     * @param name
     * @return
     */
    @Override
    public Class findClass(String name) {
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }

    /**
     * 用于加载类文件
     *
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) {
        name = path + name + ".class";
        try (InputStream inputStream = new FileInputStream(new File(name));
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            int i;
            while ((i = inputStream.read()) != -1) {
                outputStream.write(i);
            }
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
