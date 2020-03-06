package com.wnxy.hospital.mims.service.stock.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.StIn;
import com.wnxy.hospital.mims.entity.StItem;
import com.wnxy.hospital.mims.entity.StItemExample;
import com.wnxy.hospital.mims.entity.StOut;
import com.wnxy.hospital.mims.exception.StException;
import com.wnxy.hospital.mims.mapper.StInMapper;
import com.wnxy.hospital.mims.mapper.StItemMapper;
import com.wnxy.hospital.mims.mapper.StOutMapper;
import com.wnxy.hospital.mims.service.stock.StInService;
import com.wnxy.hospital.mims.service.stock.StItemService;
import com.wnxy.hospital.mims.service.stock.StOutService;

@Service
public class StItemServiceImpl implements StItemService {
	@Autowired
	StItemMapper stItemMapper;

	/**
	 * 通过主键查
	 */
	@Override
	public StItem selectBySid(String sid) {
		try {
			return stItemMapper.selectByPrimaryKey(sid);
		} catch (Exception e) {
			throw new StException(e);
		}
	}

	/**
	   * 添加条目
	 */
	@Override
	public void insertStItem(StItem stItem) {
		try {
			stItemMapper.insert(stItem);
		} catch (Exception e) {
			throw new StException(e);
		}
	}

	/*
	 *   	通过药品名查询
	 */
	@Override
	public List<StItem> selectByMid(String mid) {
		StItemExample example=new StItemExample();
		example.createCriteria().andMedicineIdEqualTo(mid);
		return stItemMapper.selectByExample(example);
		
	}

}
