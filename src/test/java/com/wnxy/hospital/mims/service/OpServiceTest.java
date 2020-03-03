package com.wnxy.hospital.mims.service;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.expression.Calendars;

import com.wnxy.hospital.mims.entity.OpCard;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.service.op.Op_RegistryService;
import com.wnxy.hospital.mims.service.op.impl.Op_RegistryServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OpServiceTest {
	@Autowired
	ApplicationContext ac;

	@Test
	public void test01() {// 录入病人基本信息
		Op_RegistryServiceImpl op_RegistryServiceImpl = (Op_RegistryServiceImpl) ac.getBean("op_RegistryServiceImpl");
		OpPatientinfo opPatientinfo = new OpPatientinfo("513411111111111111", "zs",11, "男",
				new Date(19111111), new Date(), "13888888888", "ls", "13999999999", "chenedu");
		op_RegistryServiceImpl.newPatientInfo(opPatientinfo);

	}

	@Test
	public void test02() throws RuntimeException {// 新办就诊卡，因为有病人身份证号外键，做测试前需要先录入病人基本信息
		Op_RegistryServiceImpl op_RegistryServiceImpl = (Op_RegistryServiceImpl) ac.getBean("op_RegistryServiceImpl");
		String pt_id = "513411111111111112";
		op_RegistryServiceImpl.newCard(pt_id);

	}

	@Test
	public void test03() {// 就诊卡挂失
		Op_RegistryServiceImpl op_RegistryServiceImpl = (Op_RegistryServiceImpl) ac.getBean("op_RegistryServiceImpl");
		OpCard opCard = new OpCard("04aa3a2c03ed4fce8461c2a668218a", "513411111111111111", 1);
		op_RegistryServiceImpl.rebondCard(opCard);
	}

	@Test
	public void test04() {// 根据身份证号查病人基本信息 Op_RegistryServiceImpl
		Op_RegistryServiceImpl op_RegistryServiceImpl = (Op_RegistryServiceImpl) ac.getBean("op_RegistryServiceImpl");
		String pt_id = "513411111111111112";
		OpPatientinfo patientInfo = op_RegistryServiceImpl.queryPatientBypt_id(pt_id);
		System.out.println(patientInfo);
	}

}
