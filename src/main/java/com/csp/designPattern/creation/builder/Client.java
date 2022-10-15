package com.csp.designPattern.creation.builder;

/**
 * @author csp
 * @date 2022/8/22
 */
public class Client {

    public static void main(String[] args) {
        FullModeBuilder fullModeBuilder = new FullModeBuilder();
        System.out.println(fullModeBuilder.build().toString());

        SimpleModeBuilder simpleModeBuilder = new SimpleModeBuilder();
        System.out.println(simpleModeBuilder.build());
    }

}
