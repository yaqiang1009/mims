package com.wnxy.hospital.mims.service.stock.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.StMedicines;
import com.wnxy.hospital.mims.entity.StMedicinesExample;
import com.wnxy.hospital.mims.entity.Supplier;
import com.wnxy.hospital.mims.mapper.StMedicinesMapper;
import com.wnxy.hospital.mims.mapper.SupplierMapper;
import com.wnxy.hospital.mims.service.stock.StMedicinesService;
import com.wnxy.hospital.mims.service.stock.SupplierService;
@Service
public class StMedicinesServiceImpl implements StMedicinesService{
	@Autowired
	StMedicinesMapper stMedicinesMapper;
	/**
	 * 通过主键查
	 */
	@Override
	public StMedicines selectById(String mid) {
		return stMedicinesMapper.selectByPrimaryKey(mid);
		
	}
	/**
	 *查询所有药品
	 */
	@Override
	public List<StMedicines> selectAll() {
		StMedicinesExample example=new StMedicinesExample();
		return stMedicinesMapper.selectByExample(example);
		
	}
	

}
