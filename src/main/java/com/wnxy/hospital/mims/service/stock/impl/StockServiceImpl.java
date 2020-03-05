package com.wnxy.hospital.mims.service.stock.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.Damages;
import com.wnxy.hospital.mims.entity.StMedicines;
import com.wnxy.hospital.mims.entity.Stock;
import com.wnxy.hospital.mims.entity.StockExample;
import com.wnxy.hospital.mims.mapper.StockMapper;
import com.wnxy.hospital.mims.service.stock.StockService;
@Service
public class StockServiceImpl implements StockService {
	@Autowired
	StockMapper stockMapper;
	
	/**
	 * 新增stock时，需要药品id做外键，所以要配合使用
	 */
	@Override
	public void insertStock(Stock stock) {
		stockMapper.insert(stock);
		
	}
	/* (non-Javadoc)
	 * 出库，库存数量减少
	 * @see com.wnxy.hospital.mims.service.stock.StockService#lessStock(com.wnxy.hospital.mims.entity.Stock)
	 */
	@Override
	public void lessStock(Stock stock) {
		Stock foundStock = stockMapper.selectByPrimaryKey(stock.getStockId());
		foundStock.setMedicineNum(foundStock.getMedicineNum()-stock.getMedicineNum());
		stockMapper.updateByPrimaryKey(foundStock);
		
	}

	/* (non-Javadoc)
	 * 查找所有库存
	 * @see com.wnxy.hospital.mims.service.stock.StockService#addStock(com.wnxy.hospital.mims.entity.Stock)
	 */
	@Override
	public List<Stock> selectAllStock() {
		StockExample example=new StockExample();
		List<Stock> Stocks = stockMapper.selectByExample(example);
		return Stocks;
	}

	/* (non-Javadoc)
	 * @see com.wnxy.hospital.mims.service.stock.StockService#addStock(com.wnxy.hospital.mims.entity.Stock)
	 */
	@Override
	public void addStock(Stock stock) {
		Stock foundStock = stockMapper.selectByPrimaryKey(stock.getStockId());
		foundStock.setMedicineNum(foundStock.getMedicineNum()+stock.getMedicineNum());
		stockMapper.updateByPrimaryKey(foundStock);
	}
	/* (non-Javadoc)
	 * @see com.wnxy.hospital.mims.service.stock.StockService#selectById(java.lang.String)
	 */
	@Override
	public Stock selectById(String id) {
		
		return stockMapper.selectByPrimaryKey(id);
	}
	
	

}
