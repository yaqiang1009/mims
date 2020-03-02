package com.wnxy.hospital.mims;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MimsApplicationTests {
	@Autowired
	ApplicationContext ac;
	
	
	@Test
	public void contextLoads() {
		System.out.println("aaa");
	}

}
