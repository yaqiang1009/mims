package com.wnxy.hospital.mims.service.op;

import com.wnxy.hospital.mims.entity.OpOptionchargestandard;

public interface OptionChargeStandardService {

	void generateOCStandard(OpOptionchargestandard ocstandard);
	
	OpOptionchargestandard getOCStandard(String ocname);
	
	void modifyOCStandard(OpOptionchargestandard ocstandard);
}
