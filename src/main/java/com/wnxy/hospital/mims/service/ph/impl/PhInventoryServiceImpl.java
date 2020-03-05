package com.wnxy.hospital.mims.service.ph.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.PhDispatch;
import com.wnxy.hospital.mims.entity.PhMedicineInventory;
import com.wnxy.hospital.mims.mapper.PhMedicineInventoryMapper;
import com.wnxy.hospital.mims.service.ph.PhDispatchService;
import com.wnxy.hospital.mims.service.ph.PhInventoryService;
@Service
public class PhInventoryServiceImpl implements PhInventoryService {
	private final Integer warnValue = 50;
	@Autowired
	PhMedicineInventoryMapper phMedicineInventoryMapper;
	@Autowired
	PhDispatchService phDispatchService;
	@Override
	//调拨单入库insert
	public int replenish(PhDispatch pd) {
		//当调拨单状态为3（已处理）时，可入库
		pd.setStatus("3");
		List<PhDispatch> phds = phDispatchService.getDispatchBycondition(pd);
		for(PhDispatch phd : phds) {
			PhMedicineInventory pi = new PhMedicineInventory();
			pi.setId(UUID.randomUUID().toString());
			pi.setMedicineId(phd.getMedicineId());
			pi.setMedicineName(phd.getMedicineName());
			
		}
		return 0;
	}
	
	//库房药品存量预警
	@Override
	public Boolean lackWarn(Integer num) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//门诊或住院部开药，根据药品id减去对应数量，并判断库存预警
	@Override
	public int minusCount(String medicineId, Integer count) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//门诊或住院部退药，根据药品id加回对应数量
	@Override
	public int returnBack(String medicineId, Integer count) {
		// TODO Auto-generated method stub
		return 0;
	}

}
