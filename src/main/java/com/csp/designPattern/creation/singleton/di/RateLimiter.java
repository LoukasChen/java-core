package com.csp.designPattern.creation.singleton.di;

/**
 * @author csp
 * @date 2022/9/24
 */
public class RateLimiter {

    private final RedisCounter redisCounter;

    public RateLimiter(RedisCounter redisCounter) {
        this.redisCounter = redisCounter;
    }

    public void test() {
        System.out.println("RateLimiter test...");
    }
}
