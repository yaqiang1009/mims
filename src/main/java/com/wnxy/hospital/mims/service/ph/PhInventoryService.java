package com.wnxy.hospital.mims.service.ph;

import com.wnxy.hospital.mims.entity.PhDispatch;

/**
 * 药房仓库管理
 * @author HL
 *
 */
public interface PhInventoryService {
	//调拨单入库insert
	int replenish(PhDispatch pd);
	//库房药品存量预警
	Boolean lackWarn(Integer num);
	//门诊或住院部开药，根据药品id减去对应数量，并判断库存预警
	int minusCount(String medicineId,Integer count);
	//门诊或住院部退药，根据药品id加回对应数量
	int returnBack(String medicineId,Integer count);
}
