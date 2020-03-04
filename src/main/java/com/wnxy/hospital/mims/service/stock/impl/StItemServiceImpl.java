package com.wnxy.hospital.mims.service.stock.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.StIn;
import com.wnxy.hospital.mims.entity.StItem;
import com.wnxy.hospital.mims.entity.StOut;
import com.wnxy.hospital.mims.mapper.StInMapper;
import com.wnxy.hospital.mims.mapper.StItemMapper;
import com.wnxy.hospital.mims.mapper.StOutMapper;
import com.wnxy.hospital.mims.service.stock.StInService;
import com.wnxy.hospital.mims.service.stock.StItemService;
import com.wnxy.hospital.mims.service.stock.StOutService;
@Service
public class StItemServiceImpl implements StItemService{
	@Autowired
	StItemMapper stItemMapper;
	/**
	 * 通过主键查
	 */
	@Override
	public StItem selectBySid(String sid) {
		return stItemMapper.selectByPrimaryKey(sid);
		
	}
	/**
	 * 添加条目
	 */
	@Override
	public void insertStItem(StItem stItem) {
		stItemMapper.insert(stItem);
		
	}
	

}
