package com.wnxy.hospital.mims.service.op.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.OpDruglist;
import com.wnxy.hospital.mims.entity.OpDruglistExample;
import com.wnxy.hospital.mims.entity.OpPrescription;
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
			String presctiptionid = "";// 获得处方id
			String medicineId = "";// 获得药品id
			BigDecimal total = new BigDecimal("0");// 药费总计
			for (OpDruglist drug : druglist) {
				// 查询当前处方中药物id
				medicineId = drug.getMedicineId();
				presctiptionid = drug.getPtId();
				OpDruglistExample example = new OpDruglistExample();
				example.createCriteria().andMedicineIdEqualTo(drug.getMedicineId()).andPtIdEqualTo(presctiptionid);
				List<OpDruglist> hasmedicine = dlmapper.selectByExample(example);
				System.out.println(hasmedicine);
				// 从药房中获取药物价格
				Double price = mcmapper.selectByPrimaryKey(medicineId).getPrice();
				if (hasmedicine.isEmpty()) {
					// 计费
					total = total
							.add(new BigDecimal(price.toString()).multiply(new BigDecimal(drug.getNum().toString())));
					drug.setSingleprice(price.floatValue());
					// 写入数据库
					dlmapper.insert(drug);
				}
			}
			System.out.println(total);
			// 计算总价，计入处方单
			OpPrescription prescription = ptmapper.selectByPrimaryKey(presctiptionid);
			prescription.setTotal(total.floatValue());
			ptmapper.updateByPrimaryKey(prescription);
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
	public void modifyDrugList(String druglistid, Integer num) {
		try {
			// 修改药单药品及其数量
			OpDruglistExample example = new OpDruglistExample();
			example.createCriteria().andDlIdEqualTo(druglistid);
			List<OpDruglist> old = dlmapper.selectByExample(example);
			old.get(0).setNum(num);
			dlmapper.updateByPrimaryKey(old.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
