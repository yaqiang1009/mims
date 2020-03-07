package com.wnxy.hospital.mims.service.ph;

import java.util.List;

import com.wnxy.hospital.mims.entity.PhMedicines;
import com.wnxy.hospital.mims.entity.ph.page.PhPageBean;

public interface PhMedicinesService {
	//根据药品id查询药品信息
	PhMedicines getMedicineById(String medicineId);
	//根据条件查询药品信息
	PhPageBean<PhMedicines> getMedicinesByCondition(PhMedicines pm, int pageIndex, int pageSize);
	//修改药品信息
	int editMedicineByCondition(PhMedicines pm);
	//根据药品名称查询药品信息
	PhMedicines getMedicineByName(String medicinesName);
	//初始化药品信息页面，查询全部信息
	PhPageBean<PhMedicines> getAllMedicine(int pageIndex, int pageSize);
	
}
