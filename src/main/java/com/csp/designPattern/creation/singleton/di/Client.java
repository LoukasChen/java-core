package com.csp.designPattern.creation.singleton.di;

/**
 * @author csp
 * @date 2022/9/24
 */
public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        RateLimiter rateLimiter = (RateLimiter)applicationContext.getBean("rateLimiter");
        rateLimiter.test();
    }
}
