package com.wnxy.hospital.mims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wnxy.hospital.mims.entity.IpBed;
import com.wnxy.hospital.mims.entity.IpBedExample;
import com.wnxy.hospital.mims.entity.IpBedExample.Criteria;
import com.wnxy.hospital.mims.mapper.IpBedMapper;
import com.wnxy.hospital.mims.service.Ip_bedService;
@Component
public class Ip_bedServiceImpl implements Ip_bedService{
	@Autowired
	private IpBedMapper ipBedMapper;
	//查询指定病房空余床位
	@Override
	public List<IpBed> selectBed(String wardId) {
		IpBedExample example=new IpBedExample();
		Criteria create = example.createCriteria();
		//添加筛选条件
		create.andWardIdEqualTo(wardId);
		List<IpBed> beds = ipBedMapper.selectLeByExample(example);
		return beds;
	}
	
	//查询所有床位
	@Override
	public List<IpBed> selectAllBed() {
		
		return null;
	}

}
