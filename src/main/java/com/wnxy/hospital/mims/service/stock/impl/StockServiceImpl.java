package com.wnxy.hospital.mims.service.stock.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.Damages;
import com.wnxy.hospital.mims.entity.StIn;
import com.wnxy.hospital.mims.entity.StItem;
import com.wnxy.hospital.mims.entity.StMedicines;
import com.wnxy.hospital.mims.entity.StOut;
import com.wnxy.hospital.mims.entity.Stock;
import com.wnxy.hospital.mims.entity.StockExample;
import com.wnxy.hospital.mims.entity.StockExample.Criteria;
import com.wnxy.hospital.mims.mapper.DamagesMapper;
import com.wnxy.hospital.mims.mapper.StInMapper;
import com.wnxy.hospital.mims.mapper.StItemMapper;
import com.wnxy.hospital.mims.mapper.StMedicinesMapper;
import com.wnxy.hospital.mims.mapper.StOutMapper;
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
	@Autowired
	StOutMapper stOutMapper;
	@Autowired
	StMedicinesMapper stMedicinesMapper;
	@Autowired
	DamagesMapper damagesMapper;
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
			//把入库单信息存到库中
			stInMapper.insert(stIn);
			
			stockMapper.insert(list.get(0));
			
		}else {
			//药库当中有此药时,数量增加
			//把条目信息添加到库中
			stItemMapper.insert(stItem);
			//把入库单信息存到域中
			stInMapper.insert(stIn);
			//修改数量
			list.get(0).setMedicineNum(list.get(0).getMedicineNum()+stItem.getMedicineNum());
	
			stockMapper.updateByPrimaryKey(list.get(0));
		}
		
	}

	@Override
	public void lessStock(StOut stOut, StItem stItem) {
		// 减少库存
		//先查询库存当中是否有这个药
		StockExample example=new StockExample();
		Criteria criteria = example.createCriteria();
		
		//查找出库单的药品,药库当中是否存在
		criteria.andMedicineIdEqualTo(stItem.getMedicineId());
		List<Stock> list = stockMapper.selectByExample(example);
		if(list.size()==0) {
			//表示没有这个药
		}else {
			//把条目信息添加到库中
			stItemMapper.insert(stItem);
			//把入库单信息存到域中
			stOutMapper.insert(stOut);
			//修改库存当中数量
			list.get(0).setMedicineNum(list.get(0).getMedicineNum()-stItem.getMedicineNum());
			
			stockMapper.updateByPrimaryKey(list.get(0));
			//判断修改后的药品库存是否低于警戒数量
			if(list.get(0).getMedicineNum()<50) {
				StMedicines foundMedicine = stMedicinesMapper.selectByPrimaryKey(list.get(0).getMedicineId());
				//发出警戒消息
				System.out.println("已出库,"+foundMedicine.getMedicineName()+"需要补充");
			}
		}
	}

	@Override
	public void frmLoss(Damages damages) {
		
		StockExample example=new StockExample();
		Criteria criteria = example.createCriteria();
		
		//查找报损单的药品,药库当中是否存在
		criteria.andMedicineIdEqualTo(damages.getMedicineId());
		List<Stock> list = stockMapper.selectByExample(example);
		if(list.size()==0) {
			//表示没有这个药
		}else {
			//表示已经由药库处理
			damages.setStatus(1);
			//表示由药库提交
			damages.setSource("1");
			damagesMapper.insert(damages);
			
			
		}
	}
	
	

}
