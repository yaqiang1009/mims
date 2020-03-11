package com.wnxy.hospital.mims.service.op.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.OpDruglist;
import com.wnxy.hospital.mims.entity.OpDruglistExample;
import com.wnxy.hospital.mims.entity.OpPrescription;
import com.wnxy.hospital.mims.entity.PhMedicines;
import com.wnxy.hospital.mims.mapper.OpDruglistMapper;
import com.wnxy.hospital.mims.mapper.OpPrescriptionMapper;
import com.wnxy.hospital.mims.mapper.PhMedicinesMapper;
import com.wnxy.hospital.mims.service.op.DrugListService;

@Service
public class DrugListServiceImpl implements DrugListService {

	@Autowired
	OpDruglistMapper dlmapper;

	@Autowired
	OpPrescriptionMapper ptmapper;

	@Autowired
	PhMedicinesMapper mcmapper;

	
	@Override
	public void generateDrugList(List<OpDruglist> druglist) {
		try {
			String prescriptionid = druglist.get(0).getPtId();// 获得处方id
			String medicineId = "";// 获得药品id
			Integer num = 0; //药品数量
			for (OpDruglist drug : druglist) {
				// 药品id 处方id 数量
				medicineId = drug.getMedicineId();
				num = drug.getNum();

				// 调用药房的代码，获取药品单价
				PhMedicines medicine = mcmapper.selectByPrimaryKey(medicineId);
				Double price = medicine.getPrice();

				// 使用数据库的药品单价
				drug.setSingleprice(price.floatValue());
				
				// 写入药品详情表
				dlmapper.insert(drug);
				
				// 调用药房的代码，扣库存
				medicine.setNumber(medicine.getNumber() - num);
				mcmapper.updateByPrimaryKey(medicine);
			}
			// 总计
			BigDecimal total = getPrescriptionTotal(prescriptionid);
			System.out.println(total);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OpDruglist> getDrugList(String prescriptionid) {
		try {
			OpDruglistExample example = new OpDruglistExample();
			example.createCriteria().andPtIdEqualTo(prescriptionid);
			return dlmapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void modifyDrugList(String prescriptionid,String medicineid, Integer num) {
		try {
			// 修改药单药品及其数量
			OpDruglistExample example = new OpDruglistExample();
			example.createCriteria().andPtIdEqualTo(prescriptionid).andMedicineIdEqualTo(medicineid);
			List<OpDruglist> druglist = dlmapper.selectByExample(example);
			// 判断该处方单是否已完成支付，已支付或已完成不能修改
			OpPrescription prescriptioin = ptmapper.selectByPrimaryKey(prescriptionid);
			if (prescriptioin.getState() == 0&&druglist.size()>0) {
				// 修改数量
				druglist.get(0).setNum(num);
				dlmapper.updateByPrimaryKey(druglist.get(0));
				// 修改费用
				getPrescriptionTotal(prescriptionid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BigDecimal getPrescriptionTotal(String prescriptionid) {
		// 统计计费
		BigDecimal total = new BigDecimal("0");// 药费总计
		
		List<OpDruglist> drugList = getDrugList(prescriptionid);
		for(OpDruglist drug:drugList) {
			total = total.add(new BigDecimal(drug.getSingleprice().toString())
					.multiply(new BigDecimal(drug.getNum().toString())));
		}
		// 计算总价，计入处方单
		OpPrescription prescription = ptmapper.selectByPrimaryKey(prescriptionid);
		prescription.setTotal(total.floatValue());
		ptmapper.updateByPrimaryKey(prescription);
		return total;
	}
}
