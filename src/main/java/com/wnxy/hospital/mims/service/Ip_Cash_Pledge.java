package com.wnxy.hospital.mims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.IpCashPledge;
import com.wnxy.hospital.mims.entity.IpCashUse;
import com.wnxy.hospital.mims.entity.IpPaymentOrder;

public interface Ip_Cash_Pledge {
	PageInfo<IpCashPledge> selectAllCash(String name,int index);
	void cashBargain(String cashId,Double price);
	PageInfo<IpPaymentOrder> selectBargainHis(String ptId,int index);
	PageInfo<IpCashUse> selectBargainUseHis(String ptId,int index);
}
