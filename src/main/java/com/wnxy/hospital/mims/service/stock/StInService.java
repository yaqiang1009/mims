package com.wnxy.hospital.mims.service.stock;

import com.wnxy.hospital.mims.entity.StIn;

public interface StInService {
	StIn selectBySid(String sid);
	void insertStIn(StIn stIn);
}
