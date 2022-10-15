package com.csp.designPattern.creation.singleton.di;

import java.io.InputStream;
import java.util.List;

/**
 * @author csp
 * @date 2022/9/24
 */
public interface BeanConfigParser {

    List<BeanDefinition> parse(InputStream inputStream);

    List<BeanDefinition> parse(String configContent);

}
