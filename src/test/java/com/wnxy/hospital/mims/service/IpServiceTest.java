package com.wnxy.hospital.mims.service;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.wnxy.hospital.mims.entity.IpBed;
import com.wnxy.hospital.mims.entity.IpHospitalized;
import com.wnxy.hospital.mims.entity.IpWard;
import com.wnxy.hospital.mims.mapper.IpBedMapper;
import com.wnxy.hospital.mims.mapper.IpHospitalizedMapper;
import com.wnxy.hospital.mims.mapper.IpWardMapper;
import com.wnxy.hospital.mims.service.impl.Op_Ip_OrderImpl;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class IpServiceTest {
	@Autowired
	ApplicationContext ac;
	
	
	@Test
	public void contextLoads() {
		
		IpWardMapper ward = (IpWardMapper)ac.getBean("ipWardMapper");
		IpWard record=new IpWard("003", "病房1");
		ward.insert(record);
		System.out.println("完成");
	}
	//添加住院订单dao
	@Test
	public void op_ip_orderDaoTest() {
		//创建订单对象
		IpHospitalized record=new IpHospitalized("11815dc20ca643f0ad601e8fecd87c18", 
				"11822dc20ca643f0ad602e8fecd87c18", "11822dc20ca643f0ad602e8fecd17c21",
		"有病", "申请中", "", new Date());
		//插入数据
		IpHospitalizedMapper ipHospitalizedMapper = (IpHospitalizedMapper)ac.getBean("ipHospitalizedMapper");
		ipHospitalizedMapper.insert(record);
	}
	//添加住院订单service
	@Test
	public void op_ip_orderImplTest() {
		Op_Ip_Order op_Ip_Order = (Op_Ip_Order)ac.getBean("op_Ip_OrderImpl");
		String addOrder = op_Ip_Order.addOrder("11822dc20ca643f0ad602e8fecd87c18", 
				"11822dc20ca643f0ad602e8fecd17c21", "他有病");
		 System.out.println(addOrder);
	}

}
