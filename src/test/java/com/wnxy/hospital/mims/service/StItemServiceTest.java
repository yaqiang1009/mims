package com.wnxy.hospital.mims.service;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.wnxy.hospital.mims.entity.StItem;
import com.wnxy.hospital.mims.service.stock.StItemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StItemServiceTest {
	@Autowired
	ApplicationContext ac;
	@Test
	public void testAdd() {
		StItemService StItemService = (StItemService) ac.getBean("stItemServiceImpl");
	
		StItem stItem=new StItem(UUID.randomUUID().toString(), "1", null, "1", null, 100);
		StItemService.insertStItem(stItem);
	}
	
}
