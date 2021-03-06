package com.wnxy.hospital.mims.service.ph.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.Damages;
import com.wnxy.hospital.mims.entity.DamagesExample;
import com.wnxy.hospital.mims.entity.DamagesExample.Criteria;
import com.wnxy.hospital.mims.entity.PhMedicines;
import com.wnxy.hospital.mims.exception.PhMedicineException;
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
		try {
			//添加主键
			damage.setDamageId(UUID.randomUUID().toString());
			//添加来源为药房
			damage.setSource("ph");
			//添加默认状态为1--待审批
			damage.setStatus(1);
			int num = damagesMapper.insertSelective(damage);
			return num;
		} catch (Exception e) {
			throw new PhMedicineException(e);
		}
	}
	//查询单个报损表
	@Override
	public Damages getDamageById(String damageId) {
		Damages damage = damagesMapper.selectByPrimaryKey(damageId);
		//根据报损单的药品编号查询药品信息
		PhMedicines phMedicines = phMedicinesMapper.selectByPrimaryKey(damage.getMedicineId());
		//damage.setPhMedicines(phMedicines);
		return damage;
	}
	//根据条件查询报损表
	@Override
	public List<Damages> getDamageByCondition(Damages damage) {
		DamagesExample de = new DamagesExample();
		Criteria cc = de.createCriteria();
		cc.andDamageIdLike("%"+damage.getDamageId()+"%");
		//根据报损数量查询,数量完全相等
		cc.andMedicineCountGreaterThan(damage.getMedicineCount());
		//根据状态查询
		cc.andStatusEqualTo(damage.getStatus());
		//根据来源(药房、药品)查询
		cc.andSourceLike("%"+damage.getSource()+"%");
		//通过药品名称获取药品编号
		cc.andMedicineNameLike("%"+damage.getMedicineName()+"%");
		try {
			List<Damages> damages = damagesMapper.selectByExample(de);
			return damages;
		} catch (Exception e) {
			throw new PhMedicineException(e);
		}
	}
}
