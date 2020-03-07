package com.wnxy.hospital.mims.service.stock;

import java.util.List;

import com.wnxy.hospital.mims.entity.StItem;
import com.wnxy.hospital.mims.entity.StOut;

public interface StOutService {
	
	StOut selectBySid(String sid);
	void insertStOut(StOut stOut);
	List<StOut> selectByItems(List<StItem> stItems);
	List<StOut> selectYueBaoBiao(String yue);
}
