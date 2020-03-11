package com.wnxy.hospital.mims.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wnxy.hospital.mims.entity.OpPrescription;
import com.wnxy.hospital.mims.entity.OpTreatment;
import com.wnxy.hospital.mims.entity.PhMedicines;
import com.wnxy.hospital.mims.service.op.impl.PrescriptionServiceImpl;
import com.wnxy.hospital.mims.service.op.impl.TreatmentServiceImpl;
import com.wnxy.hospital.mims.service.ph.impl.PhMedicinesServiceImpl;
import com.wnxy.hospital.mims.utils.MyUuid;

@Controller
@RequestMapping("/prescription")
public class PrescriptionController {

	@Autowired
	PrescriptionServiceImpl prescriptionservice;

	@Autowired
	TreatmentServiceImpl treatmentservice;

	@Autowired
	PhMedicinesServiceImpl medicineservice;
	
	@RequestMapping("/setsetPrescription")
	@ResponseBody
	public String generatePrescription(@RequestBody Map<String, String> map) {
		String empId = map.get("empid");
		try {
			// 获取门诊编号
			OpTreatment treatment = treatmentservice.getTreatment(0);
			String tmId = treatment.getTmId();
			OpPrescription prescription = new OpPrescription(MyUuid.getMyUuid(), tmId, empId, new Date(), null, 0F, 0);
			prescriptionservice.generatePrescription(prescription);
			return prescription.getPtId();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/getDrug")
	@ResponseBody
	public Object getDrug(@RequestBody Map<String, String> map) {
		String drugname = map.get("drugname");
		try { 
			PhMedicines medicine = medicineservice.getMedicineByName(drugname);
			if(medicine!=null) {
				return medicine;
			}else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
