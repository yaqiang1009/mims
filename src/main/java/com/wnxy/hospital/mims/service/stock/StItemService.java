package com.wnxy.hospital.mims.service.stock;

import java.util.List;

import com.wnxy.hospital.mims.entity.StItem;

public interface StItemService {
	StItem selectBySid(String sid);
	void insertStItem(StItem stItem);
	List<StItem> selectByMid(String mid);
}
