package com.szt.myioc;
import com.szt.myioc.factory.AutowireBeanFactory;
import com.szt.myioc.factory.BeanFactory;
import com.szt.myioc.service.HelloWorld;
import org.junit.Test;

/**
 * ����
 *
 * @author stateis0
 */
public class BeanFactoryTest {

  // ��ȫ����
  private final String classname = "cn.thinkinjava.myspring.test.HelloWorld";
  // ��������
  private final String property = "text";
  // ����ֵ
  private String value = "�����Զ���";
  // ��id
  private final String name = "hello";

  @Test
  public void test() throws Exception {

    // �����Զ�ע��bean����
    BeanFactory beanfactory = new AutowireBeanFactory();
    // ����һ��bean�������
    BeanDefinition beandefinition = new BeanDefinition();
    // ��bean���������������������class����
    beandefinition.setClassname(classname);

    // ����һ����Ա��������
    PropertyValues pv = new PropertyValues();

    // ��bean�������ó�Ա��������
    beandefinition.setPropertyValues(pv);

    // ��bean�������ӳ�Ա��������
    beandefinition.getPropertyValues().addPropertyValue(new PropertyValue(property, value));

    // bean������bean����ע�ᵽ������
    beanfactory.registerBeanDefinition(name, beandefinition);

    // �������л�ȡbeanʵ��
    HelloWorld hello = (HelloWorld) beanfactory.getBean(name);

    // ����ʵ������
//    hello.say();


  }

}