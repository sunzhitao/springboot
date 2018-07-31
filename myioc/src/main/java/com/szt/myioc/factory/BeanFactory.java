package com.szt.myioc.factory;

import  com.szt.myioc.BeanDefinition;

/**
 * @author: sunzhitao
 * @date: 2018/7/22 16:26
 * @description: IOC容器的接口 需要两个基本方法 注册bean 获取bean
 */
public interface BeanFactory {

    /**
     * 根据bean的名字获取ioc容器中的bean
     * @return bean实例
     * @throws Exception
     */
    Object getBean(String name) throws Exception;

    /**
     * 将bean注册到ioc容器中
     * @param name
     * @param beanDefinition
     * @throws Exception
     */
    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws  Exception;
}
