package com.csp.designPattern.creation.singleton.di;

/**
 * @author csp
 * @date 2022/9/24
 */
public class RedisCounter {

    private String ip;

    private int port;

    public RedisCounter(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}
