package com.johnny.restdemo;

import com.johnny.restdemo.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestDemoApplicationTests {

	@Test
	public void contextLoads() {
		Employee employee  = new Employee(1L,"johnny", 36);
	}

}
