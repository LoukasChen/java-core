package com.csp.designPattern.creation.singleton.di;

/**
 * @author csp
 * @date 2022/9/24
 */
public interface ApplicationContext {

    Object getBean(String name);

}
