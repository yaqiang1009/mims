package com.wnxy.hospital.mims.service.op;

import com.wnxy.hospital.mims.entity.OpPrescription;

public interface PrescriptionService {
	
	String generatePrescription(OpPrescription prescription);
	
	OpPrescription getPrescription(String prescirptionid);
	
	void modifyPrescription(String prescirptionid,Integer state);
}
