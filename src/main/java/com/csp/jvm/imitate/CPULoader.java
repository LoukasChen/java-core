package com.csp.jvm.imitate;

/**
 * @desc: CPU负载过高
 * @author: csp52872
 * @date: 2021/10/6
 */
public class CPULoader {

    public static void main(String[] args) {
        createThreadLoop();
    }

    private static void createThreadLoop() {
        while (true) {
            new Thread().start();
        }
    }

}