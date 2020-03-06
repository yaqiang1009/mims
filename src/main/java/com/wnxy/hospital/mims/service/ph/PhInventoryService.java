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
	//根据药品编号设置药品预警数量
	int updateWarnValueById(String medicineId, Integer count);
	//一键修改预警数量，改全部药品
	int updateAllWarnValue(Integer count);
	//根据药品编号判断库房药品存量是否预警
	Boolean lackWarn(String medicineId, Integer num);
	//门诊或住院部开药，根据药品id减去对应数量，并判断库存预警
	int minusCount(Integer count, String medicineId);
	//门诊或住院部退药，根据药品id加回对应数量
	int returnBack(Integer count, String medicineId);
	
}
