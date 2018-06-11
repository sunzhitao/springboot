package com.szt.springbootredis2.service;

import com.szt.springbootredis2.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by sunzhitao on 2018/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RedisServiceTest {
    @Autowired
    private RedisService redisService;

    @Test
    public void addUser() {
        User user = new User();
        user.setName("susan");
        user.setAge(18);
        redisService.addUser(user);
    }

    @Test
    public void getUser() {
        System.out.println("user  getUser start ========================================== " );
        String name ="susan";
        String user = redisService.getUser(name);
        System.out.println("user = " + user);
        System.out.println("user  getUser end ========================================== " );
    }
}