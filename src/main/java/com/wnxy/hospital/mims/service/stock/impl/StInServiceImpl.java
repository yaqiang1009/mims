package com.wnxy.hospital.mims.service.stock.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.StIn;
import com.wnxy.hospital.mims.entity.StInExample;
import com.wnxy.hospital.mims.entity.StItem;
import com.wnxy.hospital.mims.entity.StInExample.Criteria;
import com.wnxy.hospital.mims.entity.StOut;
import com.wnxy.hospital.mims.exception.StException;
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
		try {
		return stInMapper.selectByPrimaryKey(sid);
	} catch (Exception e) {
		throw new StException(e);
	}
	}
	/**
	 * 新增入库单，要配合添加条目使用
	 */
	@Override
	public void insertStIn(StIn stIn) {
		try {
		stInMapper.insert(stIn);
	} catch (Exception e) {
		throw new StException(e);
	}
	}
	/* 
	 * 查看所有入库单
	 */
	@Override
	public List<StIn> selectAll() {
		StInExample example=new StInExample();
		example.setOrderByClause("time");
		return stInMapper.selectByExample(example);
		
	}
	/* 
	 * 		通过所有的条目集合查询入库集合，并加上分页
	 */
	@Override
	public List<StIn> selectByItems(List<StItem> stItems) {
		try {
			List<StIn> list =new ArrayList<StIn>();
			List<StIn> found=new ArrayList<StIn>();
			for(StItem s:stItems) {
				StInExample example=new StInExample();
				example.createCriteria().andItemIdEqualTo(s.getItemId());
				found = stInMapper.selectByExample(example);
				if(found.size()!=0) {
					list.add(found.get(0));
				}
				
			}
			return list;
		}catch (Exception e) {
			throw new StException("Impl错误");
		}
	}

}
