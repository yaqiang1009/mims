package com.wnxy.hospital.mims.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.IpBed;
import com.wnxy.hospital.mims.entity.IpHospitalized;
import com.wnxy.hospital.mims.entity.IpIllness;
import com.wnxy.hospital.mims.entity.IpIllnessExample;
import com.wnxy.hospital.mims.entity.IpRemedy;
import com.wnxy.hospital.mims.entity.IpWard;
import com.wnxy.hospital.mims.entity.Office;
import com.wnxy.hospital.mims.entity.OpDep;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.mapper.EmpMapper;
import com.wnxy.hospital.mims.mapper.IpBedMapper;
import com.wnxy.hospital.mims.mapper.IpHospitalizedMapper;
import com.wnxy.hospital.mims.mapper.IpRemedyMapper;
import com.wnxy.hospital.mims.mapper.IpWardMapper;
import com.wnxy.hospital.mims.mapper.OfficeMapper;
import com.wnxy.hospital.mims.mapper.OpDepMapper;
import com.wnxy.hospital.mims.mapper.OpPatientinfoMapper;
import com.wnxy.hospital.mims.service.impl.Op_Ip_OrderImpl;
import com.wnxy.hospital.mims.service.ip.impl.Ip_IllnessServiceImpl;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class IpServiceTest {
	@Autowired
	ApplicationContext ac;
	
	//添加病房
	@Test
	public void text01() {
		IpWardMapper ward = (IpWardMapper)ac.getBean("ipWardMapper");
		IpWard record=new IpWard("005", "病房5");
		ward.insert(record);
	}
	
	@Test
	public void op_ip_orderDaoTest() {
		//创建订单对象
		IpHospitalized record=new IpHospitalized("11815dc20ca643f0ad601e8fecd87c18", 
				"11822dc20ca643f0ad602e8fecd87c18", null, "11822dc20ca643f0ad602e8fecd17c21",
		null, "有病", "申请中", "", new Date());
		//插入数据
		IpHospitalizedMapper ipHospitalizedMapper = (IpHospitalizedMapper)ac.getBean("ipHospitalizedMapper");
		ipHospitalizedMapper.insert(record);
	}
	
	//添加住院订单
	@Test 
	public void text() { 
		//创建订单对象
		IpHospitalized record=new IpHospitalized("11815dc20ca643f0ad601e8fecd87c18",
						  "11822dc20ca643f0ad602e8fecd87c18", null, "11822dc20ca643f0ad602e8fecd17c21", null, "有病",
						  "申请中", "", new Date()); 
		//插入数据 
		IpHospitalizedMapper ipHospitalizedMapper =(IpHospitalizedMapper)ac.getBean("ipHospitalizedMapper");
		ipHospitalizedMapper.insert(record); 
	}
	 
	//添加住院订单service
	@Test
	public void text0() {
		Op_Ip_Order op_Ip_Order = (Op_Ip_Order)ac.getBean("op_Ip_OrderImpl");
		String addOrder = op_Ip_Order.addOrder("11822dc20ca643f0ad602e8fecd87c18", 
				"11822dc20ca643f0ad602e8fecd17c21", "他还是有病");
		 System.out.println(addOrder);
	}

	//检索住院单
	@Test
	public void selectAllHosTest() {
		Ip_HosOrderService ip_HosOrderService = (Ip_HosOrderService)ac.getBean("ip_HosOrderServiceImpl");
		List<IpHospitalized> selectAllHos = ip_HosOrderService.selectAllHos();
		for(IpHospitalized hos:selectAllHos) {
			System.out.println(hos);
		}
	}

	//检索指定住院单
	@Test
	public void selectHosTest() {
		Ip_HosOrderService ip_HosOrderService = (Ip_HosOrderService)ac.getBean("ip_HosOrderServiceImpl");
		IpHospitalized selectHos = ip_HosOrderService.selectHos("7264e2cfcd4b4df18e5d620940fabb4c");
			System.out.println(selectHos);
	}
	
	//添加病情订单service
	@Test
	public void ip_IllnessServiceImplText01() {
		Ip_IllnessServiceImpl ip_IllnessServiceImpl = (Ip_IllnessServiceImpl) ac.getBean("ip_IllnessServiceImpl");
		IpIllness ipIllness= new IpIllness();
		ipIllness.setIllness("病的不清");
		ipIllness.setCaution("吃药");
		ipIllness.setRemedyId("66e33789f0a84e7985ce748015e4b5df");
		ip_IllnessServiceImpl.addIllnessOrder(ipIllness);
	}
	
	//修改病情订单service
	@Test
	public void ip_IllnessServiceImplText02() {
		Ip_IllnessServiceImpl ip_IllnessServiceImpl = (Ip_IllnessServiceImpl) ac.getBean("ip_IllnessServiceImpl");
		IpIllness ipIllness= new IpIllness();
		ipIllness.setIllnessId("858508a5d25f427491381992b9e26781");
		ipIllness.setIllness("病好了");
		ipIllness.setCaution("不吃药");
		String updateIllnessOrder = ip_IllnessServiceImpl.updateIllnessOrder(ipIllness);
		System.out.println(updateIllnessOrder);
	}
	
	//查询所有病情订单service，不带条件
	@Test
	public void ip_IllnessServiceImplText03() {
		Ip_IllnessServiceImpl ip_IllnessServiceImpl = (Ip_IllnessServiceImpl) ac.getBean("ip_IllnessServiceImpl");
		IpIllnessExample example= new IpIllnessExample();
		List<IpIllness> list = ip_IllnessServiceImpl.selectIpIllnessByExample(example);
		for(IpIllness ipIllness : list) {
			System.out.println(ipIllness);
		}

	}
}
