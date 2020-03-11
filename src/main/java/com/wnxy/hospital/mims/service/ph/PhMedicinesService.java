package com.wnxy.hospital.mims.service.ph;

import java.util.List;

import com.wnxy.hospital.mims.entity.PhMedicines;

public interface PhMedicinesService {
	//根据药品id查询药品信息
	PhMedicines getMedicineById(String medicineId);
	//根据条件查询药品信息
	List<PhMedicines> getMedicinesByCondition(PhMedicines pm);
	//修改药品信息
	int editMedicineByCondition(PhMedicines pm);
	//根据药品名称查询药品信息
	PhMedicines getMedicineByName(String medicinesName);
	//初始化药品信息页面，查询全部信息
	List<PhMedicines> getAllMedicine();
	
}
