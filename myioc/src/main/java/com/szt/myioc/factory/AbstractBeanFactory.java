package com.szt.myioc.factory;

import com.szt.myioc.BeanDefinition;

import java.util.HashMap;

/**
 * @author: sunzhitao
 * @date: 2018/7/22 18:14
 * @description: beanfactory的实现类  实现了 bean 的方法，
 * 包含一个map，用于存储bean 的名字和bean的定义
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    /**
     * 容器
     */
    private HashMap<String, BeanDefinition> map =new HashMap<>();

    /**
     * 根据bean的名称获取bean,没有则抛异常,有,从bean定义对象获取bean实例
     * @return bean的实例对象
     * @throws Exception
     */
    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = map.get(name);
        if(beanDefinition == null){
            throw new IllegalArgumentException("No bean Name "+name+" is defined");
        }

        Object bean = beanDefinition.getBean();
        if(bean==null){
            bean = doCreate(beanDefinition);
        }
        return bean;
    }

    /**
     * 注册 bean定义的抽象方法实现
     * @param name
     * @param beanDefinition
     * @throws Exception
     */
    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        Object bean = doCreate(beanDefinition);
        beanDefinition.setBean(bean);
        map.put(name,beanDefinition);

    }

    /**
     * 创建一个bean
     */
    abstract Object doCreate(BeanDefinition beandefinition) throws Exception;
}
