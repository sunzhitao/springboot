package com.szt.springbootredis2.service;

import com.szt.springbootredis2.model.User;
import com.szt.springbootredis2.utils.RedisTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by sunzhitao on 2018/6/10.
 */
@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private  RedisTemplateUtil redisTemplateUtil;


    public void addUser(User user){
        redisTemplateUtil.set(user.getName(),user.toString());
    }

    public  String getUser(String key){
        return redisTemplateUtil.get(key);
    }
}
