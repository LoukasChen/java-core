package com.csp.spi;

import java.util.ServiceLoader;

/**
 * @author: csp52872
 * @date: 2021/07/25
 */
public class ServiceLoaderApi {

    private static ServiceLoader<LoadService> loadServices = ServiceLoader.load(LoadService.class);

    public static void main(String[] args) {
        loadServices.forEach(loadService -> System.out.println(loadService.load()));
    }

}
