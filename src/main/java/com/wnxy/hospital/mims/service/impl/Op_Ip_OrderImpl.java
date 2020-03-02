package com.wnxy.hospital.mims.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wnxy.hospital.mims.entity.IpHospitalized;
import com.wnxy.hospital.mims.mapper.IpHospitalizedMapper;
import com.wnxy.hospital.mims.service.Op_Ip_Order;
@Component
public class Op_Ip_OrderImpl implements Op_Ip_Order{
	@Autowired
	IpHospitalizedMapper ipHospitalizedMapper;
	//门诊下订单
	@Override
	public String addOrder(String pt_id, String emp_id, String illness) {
		//订单主键
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		try {
			//创建订单对象
			IpHospitalized record=new IpHospitalized(uuid, pt_id, emp_id,
			illness, "申请中", "", new Date());
			//插入数据
			ipHospitalizedMapper.insert(record);
			return "插入成功";
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
			return "插入失败";
		}
	}
	

}
