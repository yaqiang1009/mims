package com.wnxy.hospital.mims.service;

import java.util.List;

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
	public void insertStock(StIn stIn) {
		
		//先查找新增单的药品,药库当中是否存在
		StockExample example=new StockExample();
		Criteria criteria = example.createCriteria();
		
		StItem stItem = stItemMapper.selectByPrimaryKey(stIn.getItemId());
		criteria.andMedicineIdEqualTo(stItem.getMedicineId());
		List<Stock> list = stockMapper.selectByExample(example);
		if(list.size()==0){
			System.out.println("没有这个药");
		}else {
			stInMapper.insert(stIn);
			list.get(0).setMedicineNum(list.get(0).getMedicineNum()+stItem.getMedicineNum());
			System.out.println(list.get(0).getMedicineNum());
			System.out.println(stItem.getMedicineNum());
			System.out.println(list.get(0));
			stockMapper.updateByPrimaryKey(list.get(0));
		}
		
	}
	
	

}
