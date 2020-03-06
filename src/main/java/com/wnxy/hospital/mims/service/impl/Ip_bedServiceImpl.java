package com.wnxy.hospital.mims.service.impl;

import java.util.List;
import java.util.UUID;

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
		example.setOrderByClause("`bed_num` ASC");
		List<IpBed> beds = ipBedMapper.selectLeByExample(example);
		return beds;
	}
	
	//查询所有床位
	@Override
	public List<IpBed> selectAllBed() {
		IpBedExample example=new IpBedExample();
		List<IpBed> ipBeds = ipBedMapper.selectByExample(example);
		return ipBeds;
	}
	//查询所有空闲的床位
	@Override
	public List<IpBed> selectLeiAllBed() {
		IpBedExample example=new IpBedExample();
		List<IpBed> ipBeds = ipBedMapper.selectLeByExample(example);
		return ipBeds;
	}
	//查询房间所有床位
	@Override
	public List<IpBed> selectWardAllBed(String wardId) {
		IpBedExample example=new IpBedExample();
		Criteria create = example.createCriteria();
		//添加筛选条件
		create.andWardIdEqualTo(wardId);
		example.setOrderByClause("`bed_num` ASC");
		List<IpBed> beds = ipBedMapper.selectByExample(example);
		return beds;
	}
	//修改床位信息
	@Override
	public void alterBed(String bedIdFor, String wardIdTo, int bedNum) {
		IpBed bed = ipBedMapper.selectByPrimaryKey(bedIdFor);
		bed.setWardId(wardIdTo);
		bed.setBedNum(bedNum);
		try {
			ipBedMapper.updateByPrimaryKey(bed);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//新增床位信息
	@Override
	public void createBed(String createWardId, int createBedNum) {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		IpBed bed=new IpBed(uuid, createWardId, null, createBedNum);
		try {
			ipBedMapper.insert(bed);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
