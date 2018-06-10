package com.szt.springbootredis.service;

import com.szt.springbootredis.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by sunzhitao on 2018/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class redisServiceTest {

    @Autowired
    private  RedisService redisService;


    @Test
    public void addUser() {
        User user = new User();
        user.setAge(18);
        user.setName("susan");
        redisService.addUser(user);
    }

    @Test
    public void getUser() {
        String key ="u";
        redisService.getUser(key);

    }
}