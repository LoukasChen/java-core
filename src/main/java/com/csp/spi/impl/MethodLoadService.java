package com.csp.spi.impl;

import com.csp.spi.LoadService;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/08/14
 */
public class MethodLoadService implements LoadService {

    @Override
    public String load() {
        return "method load";
    }

}
