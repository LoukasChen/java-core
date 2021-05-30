package com.csp.file;

import java.io.*;

public class FileStrem {
    public static void main(String[] args) {
        int flag = 0;
        // 定义字节输入流
        FileInputStream fileInputStream = null;
        // 定义字节输出流
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\apache-maven-3.6.0\\README.txt");
            fileOutputStream = new FileOutputStream("D:\\copy.txt");
            // read()方法返回一个字节
            while ((flag = fileInputStream.read()) != -1) {
                fileOutputStream.write(flag);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
