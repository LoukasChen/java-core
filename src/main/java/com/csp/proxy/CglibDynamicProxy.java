package com.csp.proxy;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * @description: cglib动态代理
 * @author: csp52872
 * @date: 2020/12/26
 */
public class CglibDynamicProxy {

    public static void main(String[] args) {
        ProxyService proxyService = getProxy(ProxyService.class);
        proxyService.invoke("test");
        proxyService.print("test");
    }

    private static <T> T getProxy(Class<T> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallbacks(new Callback[]{new MyMethodInterceptor(), NoOp.INSTANCE});
        enhancer.setCallbackFilter(new MyCallbackFilter());
        return (T) enhancer.create();
    }


    static class MyMethodInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            System.out.println("before:" + method.getName());
            Object result = methodProxy.invokeSuper(obj, args);
            System.out.println("after:" + method.getName());
            return result;
        }
    }

    static class MyCallbackFilter implements CallbackFilter {

        @Override
        public int accept(Method method) {
            // 过滤print方法，不对此方法进行拦截
            if ("print".equals(method.getName())) {
                System.out.println("filter this method=" + method.getName());
                return 1;
            }
            return 0;
        }
    }

    static class ProxyService {

        public void invoke(String str) {
            System.out.println("invoke proxy class" + str);
        }

        public void print(String str) {
            System.out.println("print proxy class" + str);
        }

    }
}
