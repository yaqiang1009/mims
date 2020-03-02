package com.wnxy.hospital.mims.service.stock;

import com.wnxy.hospital.mims.entity.StIn;
import com.wnxy.hospital.mims.entity.StItem;

public interface StockService {
	void insertStock(StIn stIn,StItem stItem);
	
}
