package com.wnxy.hospital.mims.service.stock;

import com.wnxy.hospital.mims.entity.Damages;
import com.wnxy.hospital.mims.entity.StIn;
import com.wnxy.hospital.mims.entity.StItem;
import com.wnxy.hospital.mims.entity.StOut;

public interface StockService {
	void insertStock(StIn stIn,StItem stItem);
	void lessStock(StOut stOut,StItem stItem);
	void frmLoss(Damages damages);
	
}
