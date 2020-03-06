package com.wnxy.hospital.mims.service.stock;

import java.util.List;

import com.wnxy.hospital.mims.entity.StIn;
import com.wnxy.hospital.mims.entity.StItem;

public interface StInService {
	StIn selectBySid(String sid);
	void insertStIn(StIn stIn);
	List<StIn> selectAll();
	List<StIn> selectByItems(List<StItem> stItems);
	
}
