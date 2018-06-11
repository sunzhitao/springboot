package com.szt.myinterceptor.config;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.szt.myinterceptor.Interceptor.InterceptorConfig;
import com.szt.myinterceptor.Interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by sunzhitao on 2018/6/11.
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter{


//    @Autowired
//    LogInterceptor logInterceptor;

    // 方法1
//    @Bean
//    public HttpMessageConverters fastJsonHttpMessageConverters() {
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue);
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        HttpMessageConverter<?> converter = fastConverter;
//        return new HttpMessageConverters(converter);
//    }

    // 方法1
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        String[] loginIncludeRequestPath = new String[]{
//                "/myInterceptor/**"
//        };
//
//        //注册自定义拦截器，添加拦截路径和排除拦截路径
//        registry.addInterceptor(logInterceptor).addPathPatterns(loginIncludeRequestPath);
//
//    }


    /**
     * 方法2
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/test/**").excludePathPatterns("api/path/login");

    }
}
