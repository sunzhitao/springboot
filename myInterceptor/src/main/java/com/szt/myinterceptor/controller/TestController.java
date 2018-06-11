package com.szt.myinterceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sunzhitao on 2018/6/11.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/get")
    public  String test(HttpServletRequest request, HttpServletResponse response){
        System.out.println("test | get | ok");
        return  "ok";
    }
}
