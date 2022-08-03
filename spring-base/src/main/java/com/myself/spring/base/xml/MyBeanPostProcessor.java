package com.myself.spring.base.xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean.class="+bean.getClass());
        System.out.println("2.5.后置处理器的初始化前的执行方法，会在所有bean对象初始化时被调用");
        return bean;
    }


    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean.class="+bean.getClass());
        System.out.println("3.5.后置处理器的初始化后的执行方法，会在所有bean对象初始化时被调用");
        return bean;
    }
}
