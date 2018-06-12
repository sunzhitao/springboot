package com.szt.interceptordemo.config;

import com.szt.interceptordemo.interceptor.WebInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by sunzhitao on 2018/6/12.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    public void  addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new WebInterceptor()).addPathPatterns("/test/**").excludePathPatterns("/exclude/**");

    }

}
