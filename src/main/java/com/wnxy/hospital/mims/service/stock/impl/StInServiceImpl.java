package com.wnxy.hospital.mims.service.stock.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.StIn;
import com.wnxy.hospital.mims.entity.StOut;
import com.wnxy.hospital.mims.mapper.StInMapper;
import com.wnxy.hospital.mims.mapper.StOutMapper;
import com.wnxy.hospital.mims.service.stock.StInService;
import com.wnxy.hospital.mims.service.stock.StOutService;
@Service
public class StInServiceImpl implements StInService{
	@Autowired
	StInMapper stInMapper;
	/**
	 * 通过主键查
	 */
	@Override
	public StIn selectBySid(String sid) {
		return stInMapper.selectByPrimaryKey(sid);
		
	}
	/**
	 * 通过入库单，要配合添加条目使用
	 */
	@Override
	public void insertStIn(StIn stIn) {
		stInMapper.insert(stIn);
		
	}
	

}
