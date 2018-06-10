package com.szt.springbootredis.service;

import com.szt.springbootredis.model.User;
import com.szt.springbootredis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sunzhitao on 2018/6/10.
 */
@Service
public class RedisService {

    @Autowired
    private  RedisUtil redisUtil;

        public   void addUser(User user){
            boolean u = redisUtil.set("u", user);
            System.out.println("u = " + u);
        }

        public  void getUser(String key){
            User user = (User) redisUtil.get(key);
            System.out.println("user ===== " + user.toString());

        }
}
