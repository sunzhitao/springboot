package com.szt.jpa;

import com.szt.jpa.Repository.UserRepository;
import com.szt.jpa.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJpaApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Test
    public void contextLoads() {
        userRepository.save(new User("sunny",18));
//        userRepository.save(new User("susan",12));
//        userRepository.save(new User("sunshine",20));

        User u = userRepository.findByName("susan");
        System.out.println("u:"+u.toString());

    }

}
