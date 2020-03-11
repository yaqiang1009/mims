package com.wnxy.hospital.mims.service.ip.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wnxy.hospital.mims.entity.IpDrug;
import com.wnxy.hospital.mims.entity.IpDrugDetail;
import com.wnxy.hospital.mims.entity.IpDrugExample;
import com.wnxy.hospital.mims.mapper.IpDrugDetailMapper;
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
	@Autowired
	IpDrugDetailMapper ipDrugDetailMapper;

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
	public String deleteDrugStatus(IpDrug ipDrug) {
		//先查询修改的药单的状态，能作废的只有还未取药的订单
		try {
			IpDrug selectIpDrug = ipDrugMapper.selectByPrimaryKey(ipDrug.getDrugId());
			if(selectIpDrug.getDrugStatus().equals("已取药")) {
				throw new RuntimeException("无法对已取药订单操作");
			}
			ipDrug.setDrugStatus("已取消");
			int count = ipDrugMapper.updateByPrimaryKeySelective(ipDrug);
			if(count==0) {
				return "作废失败";
			}
			return "作废成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "作废失败";
		}
	}

	/*
	 * //划价成功修改药单状态 //药单状态共有：刚生成药单时是待扣费，待取药，欠费，已取消
	 * 
	 * @Override public String updateDrugStatusWithPrice(IpDrug ipDrug,int result) {
	 * try { IpDrug selectIpDrug =
	 * ipDrugMapper.selectByPrimaryKey(ipDrug.getDrugId());
	 * if(selectIpDrug.getDrugStatus().equals("已取消")) { throw new
	 * RuntimeException("无法对作废订单操作"); } //底层划价方法返回的参数 if(result==0) { //扣费操作执行失败
	 * ipDrug.setDrugStatus("欠费"); }else { //扣费操作执行成功 ipDrug.setDrugStatus("待取药"); }
	 * int count = ipDrugMapper.updateByPrimaryKeySelective(ipDrug); if(count==0) {
	 * return "修改失败"; } return "修改成功"; } catch (Exception e) { e.printStackTrace();
	 * return "修改失败"; } }
	 */

	//查询药单详情
	@Override
	public IpDrug selectDrugByDrugId(String drugId) {
		IpDrug selectDrug = ipDrugMapper.selectByPrimaryKey(drugId);
		//查询药单明细
		List<IpDrugDetail> lists = ipDrugDetailMapper.selectByDrugId(drugId);
		//药单明细对象
		selectDrug.setIpDrugDetails(lists);
		return selectDrug;
	}

	//查询药单详情
	@Override
	public IpDrug selectDrugByIllnessId(String illnessId) {
		//查询药单
		IpDrug selectDrug = ipDrugMapper.selectByIllnessId(illnessId);
		//查询药单明细
		List<IpDrugDetail> lists = ipDrugDetailMapper.selectByDrugId(selectDrug.getDrugId());
		//药单明细对象
		selectDrug.setIpDrugDetails(lists);
		return selectDrug;
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
