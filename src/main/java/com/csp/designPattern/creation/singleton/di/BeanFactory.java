package com.csp.designPattern.creation.singleton.di;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author csp
 * @date 2022/9/24
 */
public class BeanFactory {

    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    private final Map<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap<>();

    public void addBeanDefinitions(List<BeanDefinition> beanDefinitionList) {
        for (BeanDefinition beanDefinition : beanDefinitionList) {
            beanDefinitions.putIfAbsent(beanDefinition.getId(), beanDefinition);
            if (!beanDefinition.isLazyInit() && beanDefinition.isSingleton()) {
                createBean(beanDefinition);
            }
        }
    }

    public Object getBean(String beanId) {
        BeanDefinition beanDefinition = beanDefinitions.get(beanId);
        if (beanDefinition == null) {
            throw new NoSuchBeanDefinitionException("Bean id not defined: " + beanId);
        }
        return createBean(beanDefinition);
    }

    protected Object createBean(BeanDefinition beanDefinition) {
        if (beanDefinition.isSingleton() && singletonObjects.containsKey(beanDefinition.getId())) {
            return singletonObjects.get(beanDefinition.getId());
        }

        Object bean;
        try {
            Class<?> beanClass = Class.forName(beanDefinition.getClassName());
            List<BeanDefinition.ConstructorArg> args = beanDefinition.getConstructorArgs();
            if (args.isEmpty()) {
                bean = beanClass.newInstance();
            } else {
                Class[] classes = new Class[args.size()];
                Object[] objects = new Object[args.size()];
                for (int i = 0; i < args.size(); i++) {
                    BeanDefinition.ConstructorArg arg = args.get(i);
                    if (arg.isRef()) {
                        classes[i] = arg.getType();
                        objects[i] = arg.getArg();
                    } else {
                        BeanDefinition refBeanDefinition = beanDefinitions.get(arg.getArg());
                        if (refBeanDefinition == null) {
                            throw new NoSuchBeanDefinitionException("");
                        }
                        classes[i] = Class.forName(refBeanDefinition.getClassName());
                        objects[i] = createBean(refBeanDefinition);
                    }
                }
                bean = beanClass.getConstructor(classes).newInstance(objects);
            }
        } catch (ClassNotFoundException | IllegalAccessException |
                 InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new BeanCreationFailureException("create bean failed", e);
        }
        if (beanDefinition.isSingleton()) {
            return singletonObjects.putIfAbsent(beanDefinition.getId(), bean);
        }
        return bean;
    }

}
