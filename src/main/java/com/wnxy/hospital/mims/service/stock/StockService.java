package com.wnxy.hospital.mims.service.stock;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.Stock;

public interface StockService {
	void insertStock(Stock stock);
	void lessStock(Stock stock);
	void addStock(Stock stock);
	
	List<Stock> selectAllStock();
	Stock selectById(String id);
	Stock selectByMid(String mid);
	PageInfo<Stock> selectPageStock(int pageindex,int pagesize);

}
