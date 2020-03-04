package com.wnxy.hospital.mims.service.stock;

import java.util.List;

import com.wnxy.hospital.mims.entity.Damages;
import com.wnxy.hospital.mims.entity.StIn;
import com.wnxy.hospital.mims.entity.StItem;
import com.wnxy.hospital.mims.entity.StOut;
import com.wnxy.hospital.mims.entity.Stock;

public interface StockService {
	void insertStock(Stock stock);
	void lessStock(Stock stock);
	void addStock(Stock stock);
	
	List<Stock> selectAllStock();
	Stock selectById(String id);
	
}
