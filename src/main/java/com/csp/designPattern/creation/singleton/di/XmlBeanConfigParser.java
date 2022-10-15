package com.csp.designPattern.creation.singleton.di;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author csp
 * @date 2022/9/24
 */
public class XmlBeanConfigParser implements BeanConfigParser {

    @Override
    public List<BeanDefinition> parse(InputStream inputStream) {
        String content = null;
        // todo
        return parse(content);
    }

    @Override
    public List<BeanDefinition> parse(String configContent) {
        List<BeanDefinition> beanDefinitions = new ArrayList<>();
        // todo
        return beanDefinitions;
    }

}
