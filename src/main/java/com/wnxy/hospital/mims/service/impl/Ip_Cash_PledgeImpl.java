package com.wnxy.hospital.mims.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.IpCashPledge;
import com.wnxy.hospital.mims.entity.IpCashPledgeExample;
import com.wnxy.hospital.mims.entity.IpCashUse;
import com.wnxy.hospital.mims.entity.IpCashUseExample;
import com.wnxy.hospital.mims.entity.IpDrug;
import com.wnxy.hospital.mims.entity.IpPaymentOrder;
import com.wnxy.hospital.mims.entity.IpPaymentOrderExample;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.entity.OpPatientinfoExample;
import com.wnxy.hospital.mims.mapper.IpCashPledgeMapper;
import com.wnxy.hospital.mims.mapper.IpCashUseMapper;
import com.wnxy.hospital.mims.mapper.IpPaymentOrderMapper;
import com.wnxy.hospital.mims.mapper.OpPatientinfoMapper;
import com.wnxy.hospital.mims.service.Ip_Cash_Pledge;
@Component
public class Ip_Cash_PledgeImpl implements Ip_Cash_Pledge {
	@Autowired
	private IpCashPledgeMapper ipCashPledgeMapper;
	@Autowired
	private OpPatientinfoMapper opPatientinfoMapper;
	@Autowired
	private IpPaymentOrderMapper ipPaymentOrderMapper;
	@Autowired
	private IpCashUseMapper ipCashUseMapper;
	//查询全部押金，支持病人姓名模糊查询
	@Override
	public PageInfo<IpCashPledge> selectAllCash(String name, int index) {
		IpCashPledgeExample example=new IpCashPledgeExample();
		if(!name.equals("")) {
			//模糊查询所有病人
			OpPatientinfoExample examplePt=new OpPatientinfoExample();
			examplePt.createCriteria().andPtNameLike("%"+name+"%");
			List<OpPatientinfo> pts = opPatientinfoMapper.selectByExample(examplePt);
			//获取id集合
			List<String> values=new ArrayList<String>();
			values.add("");
			for(OpPatientinfo opPatientinfo:pts) {
				values.add(opPatientinfo.getPtId());
			}
			example.createCriteria().andPtIdIn(values);
		}
		//查询所有押金表
		PageHelper.startPage(index, 8);
		List<IpCashPledge> ipCashPledges = ipCashPledgeMapper.selectByExample(example);
		//遍历，用户对象赋值
		for(IpCashPledge ipCashPledge:ipCashPledges) {
			OpPatientinfo pt = opPatientinfoMapper.selectByPrimaryKey(ipCashPledge.getPtId());
			ipCashPledge.setOpPatientinfo(pt);
		}
		PageInfo<IpCashPledge> ipCashPledgep=new PageInfo<>(ipCashPledges);
		return ipCashPledgep;
	}
	//缴费
	@Transactional
	@Override
	public void cashBargain(String cashId, Double price) {
		IpCashPledge ipCashPledge = ipCashPledgeMapper.selectByPrimaryKey(cashId);
		ipCashPledge.setRemaining(price);
		try {
			//修改余额
			ipCashPledgeMapper.addRemainingByPrimaryKey(ipCashPledge);
			//产生缴费单
			String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
			IpPaymentOrder ipPaymentOrder=new IpPaymentOrder(uuid, cashId, null, price, new Date());
			ipPaymentOrderMapper.insert(ipPaymentOrder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//查询用户缴费记录
	@Override
	public PageInfo<IpPaymentOrder> selectBargainHis(String ptId, int index) {
		//获取押金表id
		IpCashPledgeExample example=new IpCashPledgeExample();
		example.createCriteria().andPtIdEqualTo(ptId);
		List<IpCashPledge> IpCashPledges = ipCashPledgeMapper.selectByExample(example);
		//获取记录单
		IpPaymentOrderExample examplepay=new IpPaymentOrderExample();
		examplepay.createCriteria().andCashIdEqualTo(IpCashPledges.get(0).getCashId());
		PageHelper.startPage(index, 10);
		List<IpPaymentOrder> paymentOrders = ipPaymentOrderMapper.selectByExample(examplepay);
		PageInfo<IpPaymentOrder> paymentOrderp=new PageInfo<>(paymentOrders);
		return paymentOrderp;
	}
	//查询押金使用明细
	@Override
	public PageInfo<IpCashUse> selectBargainUseHis(String ptId, int index) {
		//获取押金表id
		IpCashPledgeExample example=new IpCashPledgeExample();
		example.createCriteria().andPtIdEqualTo(ptId);
		List<IpCashPledge> IpCashPledges = ipCashPledgeMapper.selectByExample(example);
		//获取记录单
		PageHelper.startPage(index, 10);
		IpCashUseExample exampleuse=new IpCashUseExample();
		exampleuse.createCriteria().andCashIdEqualTo(IpCashPledges.get(0).getCashId());
		List<IpCashUse> ipCashUses = ipCashUseMapper.selectByExample(exampleuse);
		PageInfo<IpCashUse> ipCashUsep=new PageInfo<>(ipCashUses);
		return ipCashUsep;
	}

}
