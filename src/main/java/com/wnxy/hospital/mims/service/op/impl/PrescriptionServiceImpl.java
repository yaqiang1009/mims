package com.wnxy.hospital.mims.service.op.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.OpPrescription;
import com.wnxy.hospital.mims.mapper.OpPrescriptionMapper;
import com.wnxy.hospital.mims.service.op.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

	@Autowired
	OpPrescriptionMapper psptmapper;
	
	@Override
	public String generatePrescription(OpPrescription prescription) {
		//生成处方单
		try {
			psptmapper.insert(prescription);
			return prescription.getPtId();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public OpPrescription getPrescription(String prescirptionid) {
		//获得处方单
		try {
			return psptmapper.selectByPrimaryKey(prescirptionid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void modifyPrescription(String prescirptionid, Integer state) {
		//修改处方状态
		try {
			OpPrescription old = psptmapper.selectByPrimaryKey(prescirptionid);
			old.setState(state);
			psptmapper.updateByPrimaryKey(old);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
