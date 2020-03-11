package com.wnxy.hospital.mims.service.ip.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wnxy.hospital.mims.entity.IpCashPledge;
import com.wnxy.hospital.mims.entity.IpCashUse;
import com.wnxy.hospital.mims.entity.IpDrug;
import com.wnxy.hospital.mims.entity.IpDrugDetail;
import com.wnxy.hospital.mims.entity.IpIllness;
import com.wnxy.hospital.mims.entity.IpRemedy;
import com.wnxy.hospital.mims.entity.PhMedicines;
import com.wnxy.hospital.mims.mapper.IpCashPledgeMapper;
import com.wnxy.hospital.mims.mapper.IpCashUseMapper;
import com.wnxy.hospital.mims.mapper.IpDrugDetailMapper;
import com.wnxy.hospital.mims.mapper.IpDrugMapper;
import com.wnxy.hospital.mims.mapper.IpIllnessMapper;
import com.wnxy.hospital.mims.mapper.IpRemedyMapper;
import com.wnxy.hospital.mims.mapper.PhMedicinesMapper;
import com.wnxy.hospital.mims.service.ip.Ip_DrugDetailService;
/**
 * 住院就诊详细药品单相关
 * @author Administrator
 *
 */
@Component
public class Ip_DrugDetailServiceImpl implements Ip_DrugDetailService{
	@Autowired
	IpDrugDetailMapper ipDrugDetailMapper;
	@Autowired
	IpDrugMapper ipDrugMapper;
	@Autowired
	PhMedicinesMapper phMedicinesMapper;
	@Autowired
	IpCashPledgeMapper ipCashPledgeMapper;
	@Autowired
	IpIllnessMapper ipIllnessMapper;
	@Autowired
	IpRemedyMapper ipRemedyMapper;
	@Autowired
	IpCashUseMapper ipCashUseMapper;
	
	//添加药品详情单,参数应该为一张药单上的所有药品详情
	//添加事务。
	@Transactional(rollbackFor=Exception.class)
	@Override
	public String addDrugDetailOrder(List<IpDrugDetail> ipDrugDetails,String drugId) {
		try {
			Double totalPrice=0.0;
			//遍历集合，分开插入每条数据
			for(IpDrugDetail ipDrugDetail:ipDrugDetails) {
				//详情主键生成
				ipDrugDetail.setDetailId(ipDrugDetail.getDetailId());
				//药单id相同，参数传进来
				ipDrugDetail.setDrugId(drugId);
				//插入数据
				ipDrugDetailMapper.insert(ipDrugDetail);
				//计算总价,插入的同时修改药单总价
				Integer drugNum = ipDrugDetail.getDrugNum();
				Double price = ipDrugDetail.getPrice();
				totalPrice+=drugNum*price;
			}
			/*
			 * if(true) { throw new RuntimeException("出错啦"); }
			 */
			//修改药单总价
			IpDrug ipDrug= new IpDrug();
			ipDrug.setDrugId(drugId);
			ipDrug.setTotalPrice(totalPrice);
			int count = ipDrugMapper.updateByPrimaryKeySelective(ipDrug);
			//判断是否修改成功
			if(count==0) {
				return "插入失败";
			}
			//总价修改成功，去扣取押金，根据扣取结果，修改药单状态
			//找到此药单对应的病人押金单
			IpDrug selectDrug = ipDrugMapper.selectByPrimaryKey(drugId);
			IpIllness selectIllness = ipIllnessMapper.selectByPrimaryKey(selectDrug.getIllnessId());
			IpRemedy selectRemedy = ipRemedyMapper.selectByPrimaryKey(selectIllness.getRemedyId());
			IpCashPledge ipCashPledge=ipCashPledgeMapper.selectByPtId(selectRemedy.getPtId());
			//如果押金单余额小于扣取总价
		    if((ipCashPledge.getRemaining())<totalPrice) {
		    	//修改药单状态为欠费
		    	selectDrug.setDrugStatus("欠费");
		    	ipDrugMapper.updateByPrimaryKeySelective(selectDrug);
		    }else {
		    	//反之扣取相应价格，并生成使用明细单
		    	ipCashPledge.setRemaining(totalPrice);
		    	ipCashPledgeMapper.subRemainingByPrimaryKeySelective(ipCashPledge);
		    	//修改药单状态为待取药
		    	selectDrug.setDrugStatus("待取药");
		    	ipDrugMapper.updateByPrimaryKeySelective(selectDrug);
				//添加定金使用明细表
		    	IpCashUse cashUse=new IpCashUse();
		    	//赋值
		    	cashUse.setCashUseId(cashUse.getCashUseId());
		    	cashUse.setCashUseDate(new Date());
		    	cashUse.setCashId(ipCashPledge.getCashId());
		    	cashUse.setIllnessId(selectIllness.getIllnessId());
		    	cashUse.setUseCash(totalPrice);
		    	ipCashUseMapper.insert(cashUse);
		    }
			return "插入成功";
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("出错");
		}
	}

	//查询一张药单上的所有药品详情
	@Override
	public List<IpDrugDetail> selectAllDrugDetailsByDrugId(String drugId) {
		//查询出集合
		List<IpDrugDetail> lists = ipDrugDetailMapper.selectByDrugId(drugId);
		//遍历集合,给对象
		for(IpDrugDetail ipDrugDetail:lists) {
			//药单对象
			IpDrug ipDrug = ipDrugMapper.selectByPrimaryKey(ipDrugDetail.getDrugId());
			ipDrugDetail.setIpDrug(ipDrug);
			//药品对象
			PhMedicines phMedicines=phMedicinesMapper.selectByPrimaryKey(ipDrugDetail.getMedicineId());;
			ipDrugDetail.setPhMedicines(phMedicines);
		}
		return lists;
	}

	/*
	 * //计算一张药单总价
	 * 
	 * @Override public Double getPriceTotal(String drugId) { Double priceTotal=0.0;
	 * //查询出集合 List<IpDrugDetail> lists = ipDrugDetailMapper.selectByDrugId(drugId);
	 * for(IpDrugDetail ipDrugDetail:lists) { Integer drugNum =
	 * ipDrugDetail.getDrugNum(); Double price = ipDrugDetail.getPrice();
	 * priceTotal+=drugNum*price; } return priceTotal; }
	 */

}
