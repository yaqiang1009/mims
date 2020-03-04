package com.wnxy.hospital.mims.service.ip.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wnxy.hospital.mims.entity.IpDrug;
import com.wnxy.hospital.mims.entity.IpDrugExample;
import com.wnxy.hospital.mims.mapper.IpDrugMapper;
import com.wnxy.hospital.mims.mapper.IpIllnessMapper;
import com.wnxy.hospital.mims.service.ip.Ip_DrugService;
/**
 * 住院就诊药单相关
 * @author Administrator
 *
 */
@Component
public class Ip_DrugServiceImpl implements Ip_DrugService{
	@Autowired
	IpDrugMapper ipDrugMapper;
	@Autowired
	IpIllnessMapper ipIllnessMapper;

	//添加药单
	@Override
	public String addDrugOrder(IpDrug ipDrug,String illnessId) {
		//主键
		ipDrug.setDrugId(ipDrug.getDrugId());
		//日期
		ipDrug.setDrugDate(new Date());
		//刚开具的药单状态都为待扣费
		ipDrug.setDrugStatus("待扣费");
		//外键
		ipDrug.setIllnessId(illnessId);
		//价格需要给默认值
		ipDrug.setTotalPrice(0.0);
		try {
			ipDrugMapper.insert(ipDrug);
			return "插入成功";
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
			return "插入失败";
		}
	}

	//作废药单，即修改药单状态
	@Override
	public int updateDrugStatus(IpDrug ipDrug) {
		//能作废的只有还未取药的订单
		/*
		 * IpDrugExample ipDrugExample = new IpDrugExample();
		 * ipDrugExample.createCriteria().andDrugStatusNotEqualTo("已取药");
		 * ipDrugExample.createCriteria().andDrugIdEqualTo(drugId);
		 */
		ipDrug.setDrugStatus("已取消");
		int count = ipDrugMapper.updateByPrimaryKeySelective(ipDrug);
		return count;
	}

	/*
	 * //插入药单总价
	 * 
	 * @Override public String updateDrugTotalPriceTotal(String drugId,Double
	 * totalPrice) { try { IpDrug ipDrug= new IpDrug(); ipDrug.setDrugId(drugId);
	 * ipDrug.setTotalPrice(totalPrice); int count =
	 * ipDrugMapper.updateByPrimaryKeySelective(ipDrug); //判断是否修改成功 if(count==0) {
	 * return "修改失败"; } return "修改成功"; } catch (Exception e) { // 异常处理
	 * e.printStackTrace(); return "修改失败"; } }
	 */
	
}
