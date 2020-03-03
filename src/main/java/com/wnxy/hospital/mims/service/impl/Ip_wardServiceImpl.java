package com.wnxy.hospital.mims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wnxy.hospital.mims.entity.IpWard;
import com.wnxy.hospital.mims.entity.IpWardExample;
import com.wnxy.hospital.mims.mapper.IpWardMapper;
import com.wnxy.hospital.mims.service.Ip_wardService;
@Component
public class Ip_wardServiceImpl implements Ip_wardService{
	@Autowired
	private IpWardMapper ipWardMapper;
	@Override
	public List<IpWard> selectAllWard() {
		IpWardExample example=new IpWardExample();
		List<IpWard> wards = ipWardMapper.selectByExample(example);
		return wards;
	}
}
