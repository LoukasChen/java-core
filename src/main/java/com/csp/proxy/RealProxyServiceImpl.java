package com.csp.proxy;

/**
 * @author: csp52872
 * @date: 2020/12/21
 */
public class RealProxyServiceImpl implements ProxyService {

    @Override
    public void invoke() {
        System.out.println("invoke real class");
    }
}
