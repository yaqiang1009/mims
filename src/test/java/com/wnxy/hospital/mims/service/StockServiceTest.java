package com.wnxy.hospital.mims.service;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.wnxy.hospital.mims.entity.Damages;
import com.wnxy.hospital.mims.entity.StIn;
import com.wnxy.hospital.mims.entity.StItem;
import com.wnxy.hospital.mims.entity.StOut;
import com.wnxy.hospital.mims.service.stock.StockService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceTest {
	@Autowired
	ApplicationContext ac;
	@Test
	public void testAdd() {
		StockService stockService = (StockService) ac.getBean("stockServiceImpl");
		StIn stIn=new StIn(UUID.randomUUID().toString(),"1",UUID.randomUUID().toString(),new Date());
		StItem stItem=new StItem(stIn.getItemId(), "1", "1", 5);
		stockService.insertStock(stIn,stItem);
	}
	@Test
	public void testLess() {
		StockService stockService = (StockService) ac.getBean("stockServiceImpl");
		StOut stOut=new StOut(UUID.randomUUID().toString(),UUID.randomUUID().toString(),new Date());
		StItem stItem=new StItem(stOut.getItemId(), "1", "1", 5);
		stockService.lessStock(stOut, stItem);
	}
	@Test
	public void testDamage() {
		StockService stockService = (StockService) ac.getBean("stockServiceImpl");
		
		Damages damages=new Damages(UUID.randomUUID().toString(), 5, "broken",
				"1", 0, "0");
		stockService.frmLoss(damages);
	}
}
