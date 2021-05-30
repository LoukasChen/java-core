package com.csp.file;

import java.io.*;

public class FileReaderWriter {
    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
//        try {
//            fileReader = new FileReader("D:\\apache-maven-3.6.0\\README.txt");
//            fileWriter = new FileWriter("D:\\write.txt");
//            int x = 0;
//            while ((x = fileReader.read()) != -1){
//                fileWriter.write(x);
//            }
//            fileReader.close();
//            fileWriter.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String name = "高浮雕";
        int age = 123;
        double score = 12.123;
        String str = String.format("姓名：%s,年龄,%d,成绩:%f",name,age,score);
        System.out.println(str);
        int b = 0;
        File file = new File("D:\\apache-maven-3.6.0\\README.txt");
        if (file.exists()) {
            try {
                fileReader = new FileReader(file);
                fileWriter = new FileWriter("D:\\write.txt");
                while ((b = fileReader.read()) != -1) {
                    fileWriter.write(b);
                }
                fileReader.close();
                fileWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
