package com.szt.myioc.xml;

import com.szt.myioc.BeanDefinition;
import com.szt.myioc.factory.AutowireBeanFactory;
import com.szt.myioc.io.ResourceLoader;
import com.szt.myioc.service.HelloWorld;
import com.szt.myioc.service.TestService;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author: sunzhitao
 * @date: 2018/7/22 22:36
 * @description:
 */
public class XmlBeanDefinitionReaderTest {

    @Test
   public void test()throws Exception{
       XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
       reader.readerXML("myspring.xml");
       AutowireBeanFactory factory = new AutowireBeanFactory();
       for(Map.Entry<String,BeanDefinition>beanDefinitionEntry : reader.getRegistry().entrySet()){
           factory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
       }
//       HelloWorld hello = (HelloWorld)factory.getBean("hello");
        TestService testService = (TestService)factory.getBean("testService");
        testService.sayHello();


    }
}