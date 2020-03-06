package com.wnxy.hospital.mims.service.ph.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.PhMedicines;
import com.wnxy.hospital.mims.entity.PhOutMedicine;
import com.wnxy.hospital.mims.exception.PhMedicineException;
import com.wnxy.hospital.mims.mapper.PhOutMedicineMapper;
import com.wnxy.hospital.mims.service.ph.OutMedicinesService;
import com.wnxy.hospital.mims.service.ph.PhInventoryService;

@Service
public class OutMedicinesServiceImpl implements OutMedicinesService{
	
	@Autowired
	PhOutMedicineMapper phOutMedicineMapper;
	@Autowired
	PhInventoryService phInventoryService;
	@Override
	//新增出药单,写入取药表，供门诊和住院使用
	public int insertOutMedicine(PhOutMedicine pom) {
		//添加主键
		pom.setOutId(UUID.randomUUID().toString());
		//添加默认状态1--待取药
		pom.setStatus(1);
		//加个保险，来源不为空且等于门诊的取药单，就将住院部的药单编号置为空
		if(pom.getSource()!=null&&pom.getSource().equals("op")) {
			pom.setDrugId(null);
		}
		//住院部的取药单，将门诊药单置为空
		if(pom.getSource()!=null&&pom.getSource().equals("ip")) {
			pom.setDlId(null);
		}
		int num = phOutMedicineMapper.insertSelective(pom);
		return num;
	}

	@Override
	//根据门诊药单编号查询药品信息
	public List<PhMedicines> queryByDlid(String dlid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	//根据住院药单编号查询药品信息
	public List<PhMedicines> queryByDrugid(String drugid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	//取药，将状态置为2--已取药
	public int gainAndupdateStatus(PhOutMedicine pom) {
		pom.setStatus(2);
		int num = phOutMedicineMapper.updateByPrimaryKeySelective(pom);
		return num;
	}


	@Override
	//根据状态退药，根据药单编号，将药单中的药品在库存中加上对应的数量,修改状态为3--已退药
	public int refundMedicine(PhOutMedicine pom) {
		//药单中的药品信息
		List<PhMedicines> medicines;
		//只有状态为1的才能退药
		if(pom.getStatus()==1) {
			//如果门诊退药查询门诊药单,否则是住院部退药
			if(pom.getSource().equals("op")) {
				medicines = queryByDlid(pom.getDlId());
			} else {
				medicines = queryByDrugid(pom.getDrugId());
			}
			//遍历药单调用药房库存退药
			for(PhMedicines medicine : medicines) {
				//phInventoryService.returnBack(1, medicine.getMedicineId());
			}
			return 0;
		} else {
			throw new PhMedicineException("取药单状态不正确，不能退药");
		}
	}
}
