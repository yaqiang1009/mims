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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.StIn;
import com.wnxy.hospital.mims.entity.StInExample;
import com.wnxy.hospital.mims.entity.StItem;
import com.wnxy.hospital.mims.entity.StMedicines;
import com.wnxy.hospital.mims.entity.StOut;
import com.wnxy.hospital.mims.entity.Supplier;
import com.wnxy.hospital.mims.mapper.StInMapper;
import com.wnxy.hospital.mims.service.stock.StInService;
import com.wnxy.hospital.mims.service.stock.StItemService;
import com.wnxy.hospital.mims.service.stock.StMedicinesService;
import com.wnxy.hospital.mims.service.stock.StOutService;
import com.wnxy.hospital.mims.service.stock.SupplierService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StOutServiceTest {
	@Autowired
	ApplicationContext ac;
	@Autowired
	StInMapper stInMapper;
	@Test
	public void testAdd() {
		StOutService stOutService = (StOutService) ac.getBean("stOutServiceImpl");
	
	
		StOut stOut=new StOut(UUID.randomUUID().toString(), "e2c6dbea-e77e-4744-9d74-81e7cee1ca16", 
				null, new Date());
		stOutService.insertStOut(stOut);
	}
	@Test
	public void testAdd2() {
		
		StMedicinesService stMedicinesService = (StMedicinesService) ac.getBean("stMedicinesServiceImpl");
		StItemService stItemService = (StItemService) ac.getBean("stItemServiceImpl");
		StInService stInService = (StInService) ac.getBean("stInServiceImpl");
		SupplierService supplierService = (SupplierService) ac.getBean("supplierServiceImpl");
		
		List<StMedicines> stMedicines = new ArrayList<StMedicines>();
			stMedicines = stMedicinesService.selectAll();
		
	
		List<StItem> stItems=new ArrayList<StItem>();
		List<StItem> list;
		for(StMedicines s:stMedicines) {
			list=stItemService.selectByMid(s.getMedicineId());
			for(StItem st:list) {
				stItems.add(st);
			}
		}
		Supplier supplier;
		StItem stItem;
		StMedicines stMedicine;
		PageHelper.startPage(1, 5);
		List<StIn> stIns = stInService.selectByItems(stItems);
		for (StIn s : stIns) {
			// 装配供应商
			supplier = supplierService.selectBySid(s.getSupplierId());
			s.setSupplier(supplier);
			// 条目
			stItem = stItemService.selectBySid(s.getItemId());
			stMedicine = stMedicinesService.selectById(stItem.getMedicineId());
			// 条目中的药
			stItem.setMedicines(stMedicine);
			s.setItem(stItem);

		}
		PageInfo<StIn> pageinfo=new PageInfo<StIn>(stIns);

		
	}
	@Test
	public void testAdd3() {
		StInService stInService = (StInService) ac.getBean("stInServiceImpl");
		List<StItem> stItems=new ArrayList<StItem>();
		StItem e=new StItem("dc8dd3b7-6509-4669-90fc-d58c416693e4", "1", null,
				"1", null, 100);
		stItems.add(e);
		System.out.println(stInService.selectByItems(stItems));;
	}
	@Test
	public void testAdd4() {
		StInService stInService = (StInService) ac.getBean("stInServiceImpl");
		StInExample example=new StInExample();
		example.createCriteria().andItemIdEqualTo("dc8dd3b7-6509-4669-90fc-d58c416693e4");
		System.out.println(stInMapper.selectByExample(example).get(0));
	}
	@Test
	public void testAdd5() {
		StMedicinesService stMedicinesService = 
				(StMedicinesService) ac.getBean("stMedicinesServiceImpl");
		System.out.println(stMedicinesService.selectAll());
	}

	
}
