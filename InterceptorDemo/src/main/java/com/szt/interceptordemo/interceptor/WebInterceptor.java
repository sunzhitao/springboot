package com.szt.interceptordemo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by sunzhitao on 2018/6/12.
 * 1. preHandle 表示方法请求前的处理，若其返回值为FALSE，就中断请求目标方法了，只有返回值为TRUE时才继续执行方法内容。
 * 2. postHandle 是在目标方法执行完之后执行的。
 */

public class WebInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(" WebInterceptor | preHandle ================");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(" WebInterceptor | postHandle ================");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(" WebInterceptor | afterCompletion  ================");
    }
}
