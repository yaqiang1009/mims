package com.wnxy.hospital.mims.service.ph.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.Damages;
import com.wnxy.hospital.mims.entity.DamagesExample;
import com.wnxy.hospital.mims.entity.DamagesExample.Criteria;
import com.wnxy.hospital.mims.entity.PhMedicines;
import com.wnxy.hospital.mims.mapper.DamagesMapper;
import com.wnxy.hospital.mims.mapper.PhMedicinesMapper;
import com.wnxy.hospital.mims.service.ph.DamageService;
@Service
public class DamageServiceImpl implements DamageService{
	@Autowired
	DamagesMapper damagesMapper;
	@Autowired
	PhMedicinesMapper phMedicinesMapper;
	//新增报损单
	@Override
	public int insertDamages(Damages damage) {
		int num = damagesMapper.insertSelective(damage);
		return num;
	}
	//查询单个报损表
	@Override
	public Damages getDamageById(String damageId) {
		Damages damage = damagesMapper.selectByPrimaryKey(damageId);
		//根据报损单的药品编号查询药品信息
		PhMedicines phMedicines = phMedicinesMapper.selectByPrimaryKey(damage.getMedicineId());
		damage.setPhMedicines(phMedicines);
		return damage;
	}
	//根据条件查询报损表
	@Override
	public List<Damages> getDamageByCondition(Damages damage) {
		DamagesExample de = new DamagesExample();
		Criteria cc = de.createCriteria();
		cc.andDamageIdLike("%"+damage.getDamageId()+"%");
		//根据报损数量查询
		cc.andMedicineCountEqualTo(damage.getMedicineCount());
		//根据状态查询
		cc.andStatusEqualTo(damage.getStatus());
		//默认只能查询药品的报损表
		
		//通过药品名称获取药品编号
		
		return null;
	}
}
