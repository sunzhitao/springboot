package com.szt.interceptordemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunzhitao on 2018/6/12.
 */
@RestController
@RequestMapping("/exclude")
public class ExcuteController {

    @RequestMapping("/test")
    public String excludeTest(){
        System.out.println(" ************ ExcuteController | test ");
        return "exclude";
    }
}
