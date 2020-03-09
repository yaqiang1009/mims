package com.wnxy.hospital.mims.service.op.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.OpTreatment;
import com.wnxy.hospital.mims.entity.OpTreatmentExample;
import com.wnxy.hospital.mims.mapper.OpTreatmentMapper;
import com.wnxy.hospital.mims.service.op.TreatmentService;

@Service
public class TreatmentServiceImpl implements TreatmentService {

	@Autowired
	OpTreatmentMapper ttmapper;

	@Override
	public String generateTreatment(OpTreatment treatment) {
		// 创建新的治疗方案
		try {
			ttmapper.insert(treatment);
			return treatment.getTmId();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public OpTreatment getTreatment(Integer scheme) {
		// 获得治疗方案对象
		try {
			OpTreatmentExample example = new OpTreatmentExample();
			example.createCriteria().andSchemeEqualTo(scheme);
			List<OpTreatment> results = ttmapper.selectByExample(example);
			OpTreatment result = results.get(0);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
