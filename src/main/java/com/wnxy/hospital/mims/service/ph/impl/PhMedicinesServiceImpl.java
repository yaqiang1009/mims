package com.wnxy.hospital.mims.service.ph.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.PhMedicines;
import com.wnxy.hospital.mims.entity.PhMedicinesExample;
import com.wnxy.hospital.mims.entity.PhMedicinesExample.Criteria;
import com.wnxy.hospital.mims.exception.PhMedicineException;
import com.wnxy.hospital.mims.mapper.PhMedicinesMapper;
import com.wnxy.hospital.mims.service.ph.PhMedicinesService;
@Service
public class PhMedicinesServiceImpl implements PhMedicinesService{
	@Autowired
	private PhMedicinesMapper phMedicinesMapper;
	@Override
	//根据药品id查询药品信息
	public PhMedicines getMedicineById(String medicineId) {
		try {
			PhMedicines phMedicines = phMedicinesMapper.selectByPrimaryKey(medicineId);
			return phMedicines;
		} catch (Exception e) {
			throw new PhMedicineException(e);
		}
	}
	//根据条件查询药品信息
	@Override
	public List<PhMedicines> getMedicinesByCondition(PhMedicines pm) {
		//将对象属性转换成example
		PhMedicinesExample pmExample = new PhMedicinesExample();
		Criteria cc = pmExample.createCriteria();
		//模糊搜索药品id
		cc.andMedicineIdLike("%"+pm.getMedicineId()+"%");
		//模糊搜索药品名称
		cc.andMedicineNameLike("%"+pm.getMedicineName()+"%");
		//根据药品包装类型查询
		cc.andMedicineTypeEqualTo(pm.getMedicineType());
		//小于等于药品价格
		cc.andPriceLessThanOrEqualTo(pm.getPrice());
		//模糊搜索批次号
		cc.andBatchNoLike("%"+pm.getBatchNo()+"%");
		//小于等于生产日期
		cc.andProduceDateLessThanOrEqualTo(pm.getProduceDate());
		//小于等于药品数量
		cc.andNumberLessThanOrEqualTo(pm.getNumber());
		try {
			List<PhMedicines> pms = phMedicinesMapper.selectByExample(pmExample);
			return pms;
		} catch (Exception e) {
			throw new PhMedicineException(e);
		}
	}
	//根据条件修改药品信息
	@Override
	public int editMedicineByCondition(PhMedicines pm) {
		//前台控制不能修改主键id
		int num = phMedicinesMapper.updateByPrimaryKeySelective(pm);
		return num;
	}
	//根据药品名称查询药品信息
	@Override
	public PhMedicines getMedicineByName(String medicineName) {
		PhMedicinesExample example = new PhMedicinesExample();
		example.createCriteria().andMedicineNameLike("%"+medicineName+"%");
		List<PhMedicines> pms = phMedicinesMapper.selectByExample(example);
		return pms.get(0);
	}

}
