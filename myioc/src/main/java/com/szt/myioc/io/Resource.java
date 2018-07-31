package com.szt.myioc.io;

import java.io.InputStream;

/**
 * @author: sunzhitao
 * @date: 2018/7/22 16:38
 * @description: 资源定义
 */
public interface Resource {

  /**
   * 获取输入流
   */
  InputStream getInputstream() throws Exception;
}