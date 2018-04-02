package com.szt.bootconf;

import com.szt.bootconf.properties.UserProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootConfApplicationTests {

	@Autowired
	private UserProperties userProperties;

	@Test
	public void contextLoads() {
		System.out.println(userProperties.getName()+" age:"+userProperties.getAge()+" desc:"+userProperties.getDesc());

	}

}
