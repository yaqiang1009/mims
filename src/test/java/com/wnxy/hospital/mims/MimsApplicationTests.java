package com.wnxy.hospital.mims;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.wnxy.hospital.mims.entity.Student;
import com.wnxy.hospital.mims.service.StudentService;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MimsApplicationTests {
	@Autowired
	ApplicationContext ac;
	
	@Autowired
	StudentService studentService;
	
	@Test
	public void contextLoads() {
		Student student=new Student("s036", "aa", 15, "男");
		studentService.addStu(student);
		System.out.println();
	}

}
