package com.wnxy.hospital.mims.service;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.wnxy.hospital.mims.entity.StItem;
import com.wnxy.hospital.mims.entity.StOut;
import com.wnxy.hospital.mims.service.stock.StItemService;
import com.wnxy.hospital.mims.service.stock.StOutService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StOutServiceTest {
	@Autowired
	ApplicationContext ac;
	@Test
	public void testAdd() {
		StOutService stOutService = (StOutService) ac.getBean("stOutServiceImpl");
	
	
		StOut stOut=new StOut(UUID.randomUUID().toString(), "e2c6dbea-e77e-4744-9d74-81e7cee1ca16", 
				null, new Date());
		stOutService.insertStOut(stOut);
	}
	
}
