package com.wnxy.hospital.mims.service.ph.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.PhDispatch;
import com.wnxy.hospital.mims.entity.PhMedicineInventory;
import com.wnxy.hospital.mims.entity.PhMedicineInventoryExample;
import com.wnxy.hospital.mims.entity.PhMedicineInventoryExample.Criteria;
import com.wnxy.hospital.mims.exception.PhMedicineException;
import com.wnxy.hospital.mims.mapper.PhMedicineInventoryMapper;
import com.wnxy.hospital.mims.service.ph.PhDispatchService;
import com.wnxy.hospital.mims.service.ph.PhInventoryService;

@Service
public class PhInventoryServiceImpl implements PhInventoryService {
	// private final Integer warnValue = 50;
	@Autowired
	PhMedicineInventoryMapper phMedicineInventoryMapper;
	@Autowired
	PhDispatchService phDispatchService;

	@Override
	// 调拨单入库insert
	public int replenish(PhDispatch pd) {
		// 入库成功条数
		int num = 0;
		// 当调拨单状态为3（已处理）时，可入库
		pd.setStatus("3");
		List<PhDispatch> phds = phDispatchService.getDispatchBycondition(pd);
		for (PhDispatch phd : phds) {
			PhMedicineInventory pi = new PhMedicineInventory();
			pi.setId(UUID.randomUUID().toString());
			pi.setMedicineId(phd.getMedicineId());
			pi.setMedicineName(phd.getMedicineName());
			pi.setNumber(phd.getDispatchCount());
			pi.setPrice(phd.getPrice());
			pi.setType(phd.getMedicineType());
			pi.setBatchNo(phd.getBatchNo());
			pi.setProduceDate(phd.getProduceDate());
			pi.setDisableDate(phd.getDisableDate());
			pi.setEnterDate(phd.getEnterDate());
			num = phMedicineInventoryMapper.insertSelective(pi);
		}
		return num;
	}

	// 库房药品存量预警
	@Override
	public Boolean lackWarn(String medicineId, Integer num) {// num为现有库存
		// 先查出药品预警数量
		Integer warnValue = queryPhInventory(medicineId).getWarnValue();
		if (num <= warnValue) {
			return true;
		}
		return false;
	}

	// 根据药品编号查询库存信息
	private PhMedicineInventory queryPhInventory(String medicineId) {
		PhMedicineInventoryExample pie = new PhMedicineInventoryExample();
		pie.createCriteria().andMedicineIdEqualTo(medicineId);
		List<PhMedicineInventory> pmi = phMedicineInventoryMapper.selectByExample(pie);
		return pmi.get(0);
	}

	// 门诊或住院部开药，根据药品id减去对应数量，并判断库存预警
	@Override
	public int minusCount(Integer count, String medicineId) {// count为开药数量
		// 先查出对应药品的库存数量
		Integer number = queryPhInventory(medicineId).getNumber();
		// 库存-开药数量<=预警数量，则预警
		Integer result = number - count;
		Boolean isWarn = lackWarn(medicineId, result);
		if (isWarn) {
			throw new PhMedicineException(medicineId + "该药品库存不足！");
		}
		// 可以开药
		PhMedicineInventory pi = new PhMedicineInventory();
		pi.setNumber(result);
		PhMedicineInventoryExample pie = new PhMedicineInventoryExample();
		pie.createCriteria().andMedicineIdEqualTo(medicineId);
		int num = phMedicineInventoryMapper.updateByExampleSelective(pi, pie);
		// 成功开药的药品种类
		return num;
	}

	// 门诊或住院部退药，根据药品id加回对应数量
	@Override
	public int returnBack(Integer count, String medicineId) {//count退药数量
		// 先查出对应药品的库存数量
		Integer number = queryPhInventory(medicineId).getNumber();
		PhMedicineInventory pi = new PhMedicineInventory();
		//现有库存+退药数
		pi.setNumber(number+count);
		PhMedicineInventoryExample pie = new PhMedicineInventoryExample();
		pie.createCriteria().andMedicineIdEqualTo(medicineId);
		int num = phMedicineInventoryMapper.updateByExampleSelective(pi, pie);
		return num;
	}

	// 根据药品编号设置药品预警数量
	@Override
	public int updateWarnValueById(String medicineId, Integer count) {
		PhMedicineInventory pi = new PhMedicineInventory();
		pi.setMedicineId(medicineId);
		PhMedicineInventoryExample pie = new PhMedicineInventoryExample();
		pie.createCriteria().andWarnValueEqualTo(count);
		int num = phMedicineInventoryMapper.updateByExampleSelective(pi, pie);
		return num;
	}

	// 一键修改预警数量，改全部药品
	@Override
	public int updateAllWarnValue(Integer count) {
		PhMedicineInventory pi = new PhMedicineInventory();
		pi.setWarnValue(count);
		PhMedicineInventoryExample pie = new PhMedicineInventoryExample();
		int num = phMedicineInventoryMapper.updateByExampleSelective(pi, pie);
		return num;
	}
	//条件查询仓库信息
	@Override
	public List<PhMedicineInventory> getInventory(PhMedicineInventory pmi) {
		try {
			PhMedicineInventoryExample pmie = new PhMedicineInventoryExample();
			Criteria cc = pmie.createCriteria();
			cc.andMedicineNameLike("%"+pmi.getMedicineName()+"%");
			cc.andCalssNameLike("%"+pmi.getCalssName()+"%");
			cc.andTypeLike("%"+pmi.getType()+"%");
			cc.andBatchNoLike("%"+pmi.getBatchNo()+"%");
			List<PhMedicineInventory> pmis = phMedicineInventoryMapper.selectByExample(pmie);
			return pmis;
		} catch (Exception e) {
			throw new PhMedicineException(e);
		}
	}

}
