package com.wnxy.hospital.mims.mapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.wnxy.hospital.mims.service.Op_Ip_Order;
import com.wnxy.hospital.mims.service.impl.Op_Ip_OrderImpl;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class IpMapperTest {
	@Autowired
	ApplicationContext ac;
	
	//添加病房
	@Test
	public void text01() {
		IpWardMapper ward = (IpWardMapper)ac.getBean("ipWardMapper");
		IpWard record=new IpWard("002", "病房2");
		ward.insert(record);
	}
	
	//添加病床
	@Test
	public void text02() {
		IpBedMapper ipBedMapper = (IpBedMapper) ac.getBean("ipBedMapper");
		IpBed ipBed=new IpBed();
		ipBed.setBedId("101");
		ipBed.setBedNum(1);
		ipBed.setWardId("001");
		ipBedMapper.insert(ipBed);
	}
	
	//添加院部
	@Test
	public void text03() {
		OfficeMapper officeMapper = (OfficeMapper) ac.getBean("officeMapper");
		Office office = new Office("2", "门诊部");
		officeMapper.insert(office);
	}
	
	//添加科室
	@Test
	public void text04() {
		OpDepMapper opDepMapper = (OpDepMapper) ac.getBean("opDepMapper");
		OpDep opDep = new OpDep("1", "口腔科");
		opDepMapper.insert(opDep);
	}
	
	//添加住院医生
	@Test
	public void text05() {
		EmpMapper empMapper = (EmpMapper) ac.getBean("empMapper");
		Emp emp= new Emp();
		emp.setEmpId("1");
		emp.setEmpName("李医生");
		empMapper.insert(emp);
	}
	
	//添加住院病人
	@Test
	public void text06() {
		OpPatientinfoMapper opPatientinfoMapper = (OpPatientinfoMapper) ac.getBean("opPatientinfoMapper");
		OpPatientinfo opPatientinfo= new OpPatientinfo();
		opPatientinfo.setPtId("1");
		opPatientinfo.setPtName("张三");
		opPatientinfoMapper.insert(opPatientinfo);
	}
	
	//添加住院订单
	@Test 
	public void text07() { 
		IpHospitalizedMapper ipHospitalizedMapper =(IpHospitalizedMapper)ac.getBean("ipHospitalizedMapper");
		IpHospitalized ipHospitalized=new IpHospitalized(); 
		ipHospitalized.setHospitalizedId("1");
		ipHospitalized.setEmpId("1");
		ipHospitalized.setPtId("1");
		/*
		 * Date date = new Date(); SimpleDateFormat format = new
		 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String mydate=format.format(date);
		 */
		ipHospitalized.setOrderDate(new Date());
		ipHospitalized.setHosOrder("待转院");
		ipHospitalizedMapper.insert(ipHospitalized); 
	}
	 
	//添加医疗单
	@Test
	public void text08() {
		IpRemedyMapper ipRemedyMapper = (IpRemedyMapper) ac.getBean("ipRemedyMapper");
		IpRemedy ipRemedy=new IpRemedy();
		ipRemedy.setRemedyId(ipRemedy.getRemedyId());
		ipRemedy.setHospitalizedId("1");
		ipRemedy.setWardId("001");
		ipRemedy.setBedId("101");
		ipRemedy.setPtId("1");
		ipRemedy.setEmpId("1");
		ipRemedy.setRemedyDate(new Date());
		ipRemedy.setRemedyStatus("住院");
		ipRemedyMapper.insert(ipRemedy);
	}
	
	
}
