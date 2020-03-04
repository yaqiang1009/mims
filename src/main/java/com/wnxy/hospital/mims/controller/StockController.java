package com.wnxy.hospital.mims.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wnxy.hospital.mims.service.stock.StockService;

import lombok.extern.slf4j.Slf4j;
//处理器
@Slf4j
@Controller
public class StockController {
	@Autowired
	StockService stockService;

	@RequestMapping("/st_")
	public String st_selectStockAll(Model model,HttpServletRequest request) {
		//stockService.
		
		return "aaa";
	}

//	public void insertStock(StIn stIn,StItem stItem) {
//		StockExample example=new StockExample();
//		Criteria criteria = example.createCriteria();
//		//查出此入库单对应的条目
//		//查找新增单的药品,药库当中是否存在
//		criteria.andMedicineIdEqualTo(stItem.getMedicineId());
//		List<Stock> list = stockMapper.selectByExample(example);
//		if(list.size()==0){
//			//药库没有此药时，添加此药
//			//把条目信息添加到库中
//			stItemMapper.insert(stItem);
//			//把入库单信息存到库中
//			stInMapper.insert(stIn);
//			stockMapper.insert(list.get(0));
//		}else {
//			//药库当中有此药时,数量增加
//			//把条目信息添加到库中
//			stItemMapper.insert(stItem);
//			//把入库单信息存到域中
//			stInMapper.insert(stIn);
//			//修改数量
//			list.get(0).setMedicineNum(list.get(0).getMedicineNum()+stItem.getMedicineNum());
//			stockMapper.updateByPrimaryKey(list.get(0));
//		}
//		
//	}

//	public void lessStock(StOut stOut, StItem stItem) {
//		// 减少库存
//		//先查询库存当中是否有这个药
//		StockExample example=new StockExample();
//		Criteria criteria = example.createCriteria();
//		
//		//查找出库单的药品,药库当中是否存在
//		criteria.andMedicineIdEqualTo(stItem.getMedicineId());
//		List<Stock> list = stockMapper.selectByExample(example);
//		if(list.size()==0) {
//			//表示没有这个药
//		}else {
//			//把条目信息添加到库中
//			stItemMapper.insert(stItem);
//			//把入库单信息存到域中
//			stOutMapper.insert(stOut);
//			//修改库存当中数量
//			list.get(0).setMedicineNum(list.get(0).getMedicineNum()-stItem.getMedicineNum());
//			
//			stockMapper.updateByPrimaryKey(list.get(0));
//			//判断修改后的药品库存是否低于警戒数量
//			if(list.get(0).getMedicineNum()<50) {
//				StMedicines foundMedicine = stMedicinesMapper.selectByPrimaryKey(list.get(0).getMedicineId());
//				//发出警戒消息
//				System.out.println("已出库,"+foundMedicine.getMedicineName()+"需要补充");
//			}
//		}
//	}

	

	
	
	
	/*同步请求模板
	@RequestMapping("/mycont1")
	public String mycont1(Model model,HttpServletRequest request) {
		
		return "aaa";
	}
	*/
	
	/*异步请求模板
	@ResponseBody
	@RequestMapping("/mycont1")
	public String mycont1(HttpServletRequest request) {
		
		return "aaa";
	}
	*/
	
}
