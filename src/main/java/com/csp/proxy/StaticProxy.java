package com.csp.proxy;

/**
 * @description: 静态代理
 * @author: csp52872
 * @date: 2020/12/21
 */
public class StaticProxy {

    public static void main(String[] args) {
        ProxyServiceImpl proxyService = new ProxyServiceImpl(new RealProxyServiceImpl());
        proxyService.invoke();
    }

    static class ProxyServiceImpl implements ProxyService {

        private ProxyService proxyService;

        public ProxyServiceImpl(ProxyService proxyService) {
            this.proxyService = proxyService;
        }

        @Override
        public void invoke() {
            System.out.println("static proxy before");
            this.proxyService.invoke();
            System.out.println("static proxy after");
        }
    }

}
