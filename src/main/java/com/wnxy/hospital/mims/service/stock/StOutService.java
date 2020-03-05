package com.wnxy.hospital.mims.service.stock;

import com.wnxy.hospital.mims.entity.StOut;

public interface StOutService {
	
	StOut selectBySid(String sid);
	void insertStOut(StOut stOut);
}
