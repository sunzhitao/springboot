package com.szt.myioc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sunzhitao
 * @date: 2018/7/22 16:28
 * @description: 属性集合
 */
public class PropertyValues {

  /**
   * 属性list
   */
  private final List<PropertyValue> propertyValueList = new ArrayList<>();

  /**
   * 默认构造器
   */
  public PropertyValues() {
  }

  /**
   * 添加进属性集合
   */
  public void addPropertyValue(PropertyValue pv) {
    propertyValueList.add(pv);
  }

  /**
   * 获取属性集合
   */
  public List<PropertyValue> getPropertyValues() {
    return propertyValueList;
  }
}
