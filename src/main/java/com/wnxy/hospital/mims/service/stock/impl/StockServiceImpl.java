package com.wnxy.hospital.mims.service.stock.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.StIn;
import com.wnxy.hospital.mims.entity.StItem;
import com.wnxy.hospital.mims.entity.Stock;
import com.wnxy.hospital.mims.entity.StockExample;
import com.wnxy.hospital.mims.entity.StockExample.Criteria;
import com.wnxy.hospital.mims.mapper.StInMapper;
import com.wnxy.hospital.mims.mapper.StItemMapper;
import com.wnxy.hospital.mims.mapper.StockMapper;
import com.wnxy.hospital.mims.service.stock.StockService;
@Service
public class StockServiceImpl implements StockService {
	@Autowired
	StockMapper stockMapper;
	@Autowired
	StItemMapper stItemMapper;
	@Autowired
	StInMapper stInMapper;
	@Override
	public void insertStock(StIn stIn,StItem stItem) {
		
		StockExample example=new StockExample();
		Criteria criteria = example.createCriteria();
		//查出此入库单对应的条目
		
		//查找新增单的药品,药库当中是否存在
		criteria.andMedicineIdEqualTo(stItem.getMedicineId());
		List<Stock> list = stockMapper.selectByExample(example);
		if(list.size()==0){
			//药库没有此药时，添加此药
			//把条目信息添加到库中
			stItemMapper.insert(stItem);
			//把入库单信息存到域中
			stInMapper.insert(stIn);
			
			stockMapper.insert(list.get(0));
			
		}else {
			//药库当中有此药时,数量增加
			//把入库单信息存到域中
			stInMapper.insert(stIn);
			//修改数量
			list.get(0).setMedicineNum(list.get(0).getMedicineNum()+stItem.getMedicineNum());
	
			stockMapper.updateByPrimaryKey(list.get(0));
		}
		
	}
	
	

}
