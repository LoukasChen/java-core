package com.csp.spi.impl;

import com.csp.spi.LoadService;

/**
 * @author: csp52872
 * @date: 2021/08/14
 */
public class FieldLoadService implements LoadService {

    @Override
    public String load() {
        return "field load";
    }

}
