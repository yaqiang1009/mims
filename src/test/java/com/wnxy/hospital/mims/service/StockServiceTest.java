package com.wnxy.hospital.mims.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import com.wnxy.hospital.mims.entity.StMedicines;
import com.wnxy.hospital.mims.entity.StOut;
import com.wnxy.hospital.mims.entity.Stock;
import com.wnxy.hospital.mims.mapper.StMedicinesMapper;
import com.wnxy.hospital.mims.service.stock.StMedicinesService;
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
		Stock stock=new Stock("1", "1", null, "盒", 2, "口服");
		stockService.addStock(stock);
	}
	@Test
	public void testMe() {
		StockService stockService = (StockService) ac.getBean("stockServiceImpl");
		StMedicinesService stMedicinesService = (StMedicinesService) ac.getBean("stMedicinesServiceImpl");
		List<StMedicines> stMedicines = stMedicinesService.selectByName("阿莫");
		Stock foundStock=new Stock();
		System.out.println(stMedicines);
		List<Stock> stocks = new ArrayList<Stock>();
		for (StMedicines s : stMedicines) {
			System.out.println(s.getMedicineId());
			foundStock = stockService.selectByMid(s.getMedicineId());
			foundStock.setMedicines(s);
			stocks.add(foundStock);

		}
		
	}
	
	
}
