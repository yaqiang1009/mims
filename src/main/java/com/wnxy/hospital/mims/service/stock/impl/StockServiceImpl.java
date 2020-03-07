package com.wnxy.hospital.mims.service.stock.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.Damages;
import com.wnxy.hospital.mims.entity.StMedicines;
import com.wnxy.hospital.mims.entity.Stock;
import com.wnxy.hospital.mims.entity.StockExample;
import com.wnxy.hospital.mims.exception.StException;
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
		try {
			stockMapper.insert(stock);
		} catch (Exception e) {
			throw new StException(e);
		}
	}

	/*
	 * (non-Javadoc) 出库，库存数量减少
	 * 
	 * @see
	 * com.wnxy.hospital.mims.service.stock.StockService#lessStock(com.wnxy.hospital
	 * .mims.entity.Stock)
	 */
	@Override
	public void lessStock(Stock stock) {
		try {
			Stock foundStock = stockMapper.selectByPrimaryKey(stock.getStockId());
			foundStock.setMedicineNum(foundStock.getMedicineNum() - stock.getMedicineNum());
			stockMapper.updateByPrimaryKey(foundStock);
		} catch (Exception e) {
			throw new StException(e);
		}

	}

	/*
	 * (non-Javadoc) 查找所有库存0
	 * 
	 * @see
	 * com.wnxy.hospital.mims.service.stock.StockService#addStock(com.wnxy.hospital.
	 * mims.entity.Stock)
	 */
	@Override
	public List<Stock> selectAllStock() {
		try {
			StockExample example = new StockExample();
			List<Stock> Stocks = stockMapper.selectByExample(example);
			return Stocks;
		} catch (Exception e) {
			throw new StException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wnxy.hospital.mims.service.stock.StockService#addStock(com.wnxy.hospital.
	 * mims.entity.Stock)
	 */
	@Override
	public void addStock(Stock stock) {
		try {
			Stock foundStock = stockMapper.selectByPrimaryKey(stock.getStockId());
			foundStock.setMedicineNum(foundStock.getMedicineNum() + stock.getMedicineNum());
			stockMapper.updateByPrimaryKey(foundStock);
		} catch (Exception e) {
			throw new StException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wnxy.hospital.mims.service.stock.StockService#selectById(java.lang.
	 * String)
	 */
	@Override
	public Stock selectById(String id) {
		try {
			return stockMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			throw new StException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wnxy.hospital.mims.service.stock.StockService#selectByMid(java.lang.
	 * String)
	 */
	@Override
	public Stock selectByMid(String mid) {
		try {
			StockExample example = new StockExample();
			example.createCriteria().andMedicineIdEqualTo(mid);
			List<Stock> stocks = stockMapper.selectByExample(example);
			return stocks.get(0);
		} catch (Exception e) {
			throw new StException(e);
		}
	}

	/*
	 * 分页查询
	 * 
	 * @see com.wnxy.hospital.mims.service.stock.StockService#selectPageStock(int,
	 * int)
	 */
	@Override
	public PageInfo<Stock> selectPageStock(int pageindex, int pagesize) {
		try {
			PageHelper.startPage(pageindex, pagesize);
			StockExample example = new StockExample();
			// 按照id排序
			example.setOrderByClause("stock_id+1");

			List<Stock> Stocks = stockMapper.selectByExample(example);
			PageInfo<Stock> stocksPage = new PageInfo<>(Stocks);

			return stocksPage;
		} catch (Exception e) {
			throw new StException(e);
		}
	}

}
