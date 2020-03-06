package com.wnxy.hospital.mims.service.op;

import com.wnxy.hospital.mims.entity.OpTreatment;

public interface TreatmentService {
	
	String generateTreatment(OpTreatment treatment); 
	
	OpTreatment getTreatment(String treatmentid);
}
