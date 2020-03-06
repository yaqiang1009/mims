package com.wnxy.hospital.mims.service.op.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.OpTreatment;
import com.wnxy.hospital.mims.mapper.OpTreatmentMapper;
import com.wnxy.hospital.mims.service.op.TreatmentService;

@Service
public class TreatmentServiceImpl implements TreatmentService {

	@Autowired
	OpTreatmentMapper ttmapper;
	
	@Override
	public String generateTreatment(OpTreatment treatment) {
		try {
			ttmapper.insert(treatment);
			return treatment.getTmId();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public OpTreatment getTreatment(String treatmentid) {
		try {
			return ttmapper.selectByPrimaryKey(treatmentid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
