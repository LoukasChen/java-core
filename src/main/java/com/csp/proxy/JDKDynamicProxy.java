package com.csp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: JDK动态代理
 * @author: csp52872
 * @date: 2020/12/21
 */
public class JDKDynamicProxy {

    public static void main(String[] args) throws Exception {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(new RealProxyServiceImpl());
        ProxyService proxyService = null;
        // 方式一
        Class<?> proxyClass = Proxy.getProxyClass(ProxyService.class.getClassLoader(), new Class<?>[]{ProxyService.class});
        proxyService = (ProxyService) proxyClass.getConstructor(MyInvocationHandler.class).newInstance(myInvocationHandler);

        // 方式二
        proxyService = (ProxyService) Proxy.newProxyInstance(ProxyService.class.getClassLoader(),
                new Class<?>[]{ProxyService.class}, new MyInvocationHandler(new RealProxyServiceImpl()));
        proxyService.invoke();

    }

    static class MyInvocationHandler implements InvocationHandler {

        private final Object service;

        public MyInvocationHandler(Object service) {
            this.service = service;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before:" + method.getName());
            Object result = method.invoke(service, args);
            System.out.println("after:" + method.getName());
            return result;
        }
    }

}
