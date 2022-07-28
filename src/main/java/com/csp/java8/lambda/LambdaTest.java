package com.csp.java8.lambda;

import java.io.File;
import java.io.FileFilter;

/**
 * @description:
 * @author: csp
 * @date: 2020/03/01
 */
public class LambdaTest {

    private static TestImpl test;

    public static void main(String[] args) {
        File[] files = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        File[] listFiles = new File(".").listFiles(File::isHidden);

        new File(".").listFiles(file -> file.isHidden());

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start thread");
            }
        }).start();

        new Thread(() -> System.out.println("start thread")).start();

        LambdaTest lambdaTest = new LambdaTest();
        lambdaTest.doSomeThing((Task) () -> System.out.println(111));
        lambdaTest.doSomeThing((Runnable) () -> System.out.println(111));
    }

    public void doSomeThing(Task task) {
        task.execute();
    }

    public void doSomeThing(Runnable runnable) {
        runnable.run();
    }

}
