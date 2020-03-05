package com.wnxy.hospital.mims.service.ip.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wnxy.hospital.mims.entity.IpCashPledge;
import com.wnxy.hospital.mims.entity.IpPaymentOrder;
import com.wnxy.hospital.mims.mapper.IpCashPledgeMapper;
import com.wnxy.hospital.mims.mapper.IpPaymentOrderMapper;
import com.wnxy.hospital.mims.service.ip.Ip_CashPledgeService;
/**
 * 押金单
 * @author Administrator
 *
 */
@Component
public class Ip_CashPledgeServiceImpl implements Ip_CashPledgeService{
	@Autowired
	IpCashPledgeMapper ipCashPledgeMapper;
	@Autowired
	IpPaymentOrderMapper ipPaymentOrderMapper;
	
	//充值押金，返回缴费单
	@Override
	@Transactional(rollbackFor=Exception.class)
	public String changeCashPledgeOrder(String ptId,Double remaining) {
		try {
			IpPaymentOrder ipPaymentOrder=new IpPaymentOrder();
			//先查询这个人入院办领的押金单
			IpCashPledge ipCashPledge = ipCashPledgeMapper.selectByPtId(ptId);
			if(ipCashPledge==null) {
				throw new RuntimeException("病人未办理住院");
			}
			ipCashPledge.setRemaining(remaining);
			int count = ipCashPledgeMapper.addRemainingByPrimaryKeySelective(ipCashPledge);
			if(count==0) {
				return "充值失败";
			}
			/*
			 * if(true) { throw new RuntimeException("出错啦"); }
			 */
			//充值成功，开具缴费单,设置缴费单属性
			ipPaymentOrder.setPaymentId(ipPaymentOrder.getPaymentId());
			ipPaymentOrder.setCashId(ipCashPledge.getCashId());
			ipPaymentOrder.setPaymentDate(new Date());
			ipPaymentOrder.setPayment(remaining);
			ipPaymentOrderMapper.insert(ipPaymentOrder);
			return "充值成功";
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("出错");
		}
	}

}
