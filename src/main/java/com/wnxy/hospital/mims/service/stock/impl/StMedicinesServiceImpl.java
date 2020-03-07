package com.wnxy.hospital.mims.service.stock.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.StMedicines;
import com.wnxy.hospital.mims.entity.StMedicinesExample;
import com.wnxy.hospital.mims.entity.Supplier;
import com.wnxy.hospital.mims.exception.StException;
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
		try {
		return stMedicinesMapper.selectByPrimaryKey(mid);
	} catch (Exception e) {
		throw new StException(e);
	}
	}
	/**
	 *查询所有药品
	 */
	@Override
	public List<StMedicines> selectAll() {
		try {
		StMedicinesExample example=new StMedicinesExample();
		return stMedicinesMapper.selectByExample(example);
	} catch (Exception e) {
		throw new StException(e);
	}
	}
	/* (non-Javadoc)
	 * 通过名字模糊查询
	 */
	@Override
	public List<StMedicines> selectByName(String name) {
		try {
		
		StMedicinesExample example=new StMedicinesExample();
		example.setOrderByClause("medicine_id+1");
		
		example.createCriteria().andMedicineNameLike("%"+name+"%");
		List<StMedicines> stMedicines = stMedicinesMapper.selectByExample(example);
		
		return stMedicines;
	} catch (Exception e) {
		throw new StException(e);
	}
	}
	

}
