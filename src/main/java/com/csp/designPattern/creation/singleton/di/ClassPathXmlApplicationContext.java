package com.csp.designPattern.creation.singleton.di;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author csp
 * @date 2022/9/24
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {

    private final BeanFactory beanFactory;

    private final BeanConfigParser beanConfigParser;

    public ClassPathXmlApplicationContext(String configLocation) {
        this.beanFactory = new BeanFactory();
        this.beanConfigParser = new XmlBeanConfigParser();
        loadBeanDefinitions(configLocation);
    }

    private void loadBeanDefinitions(String configLocation) {
        try (InputStream in = this.getClass().getResourceAsStream("/" + configLocation)) {
            if (in == null) {
                throw new RuntimeException("Can not find config file: "+ configLocation);
            }
            List<BeanDefinition> beanDefinitions = beanConfigParser.parse(in);
            beanFactory.addBeanDefinitions(beanDefinitions);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object getBean(String name) {
        return beanFactory.getBean(name);
    }

}
