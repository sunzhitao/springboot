package com.szt.interceptordemo.controller;


import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunzhitao on 2018/6/12.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/interceptor")
    public String interceptor(ModelMap model){
        model.addAttribute("a",111);
        System.out.println("**************  TestController | interceptor *******************");
        return "interceptor";
    }

}
