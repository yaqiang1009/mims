package com.wnxy.hospital.mims.service.ph;

import java.util.List;

import com.wnxy.hospital.mims.entity.PhMedicines;
import com.wnxy.hospital.mims.entity.PhOutMedicine;

public interface OutMedicinesService {

	//新增出药单,写入取药表，供门诊和住院使用
	void insertOutMedicineList(List<PhOutMedicine> poms);
	//根据门诊药单编号查询药品信息
	List<PhMedicines> queryByDlid(String dlid);
	//根据住院药单编号查询药品信息
	List<PhMedicines> queryByDrugid(String drugid);
	//取药，将状态置为已取药
	int gainAndupdateStatus(PhOutMedicine pom);
	//根据状态退药，根据药单编号，将药单中的药品在库存中加上对应的数量
	int refundMedicine(PhOutMedicine pom);
}
