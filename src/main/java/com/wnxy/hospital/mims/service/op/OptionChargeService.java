package com.wnxy.hospital.mims.service.op;

import com.wnxy.hospital.mims.entity.OpOptioncharge;

public interface OptionChargeService {
	
	void generateOptionCharge(OpOptioncharge optioncharge);
	
	OpOptioncharge getOptionCharge(String optionchargeid);
}
