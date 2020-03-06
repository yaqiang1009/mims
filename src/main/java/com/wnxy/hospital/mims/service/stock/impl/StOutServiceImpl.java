package com.wnxy.hospital.mims.service.stock.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.StOut;
import com.wnxy.hospital.mims.exception.StException;
import com.wnxy.hospital.mims.mapper.StOutMapper;
import com.wnxy.hospital.mims.service.stock.StOutService;
@Service
public class StOutServiceImpl implements StOutService{
	@Autowired
	StOutMapper stOutMapper;
	@Override
	public StOut selectBySid(String sid) {
		try {
		return stOutMapper.selectByPrimaryKey(sid);
	} catch (Exception e) {
		throw new StException(e);
	}
		 
	}
	/**
	 * 新增出库单时，要与新增条目表一起使用，因为在数据库中有外键存在
	 */
	@Override
	public void insertStOut(StOut stOut) {
		try {
			
		stOutMapper.insert(stOut);
	} catch (Exception e) {
		throw new StException(e);
	}
	}
	

}
