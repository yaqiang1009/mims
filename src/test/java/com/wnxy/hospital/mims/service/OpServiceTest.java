package com.wnxy.hospital.mims.service;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.Office;
import com.wnxy.hospital.mims.entity.OpCard;
import com.wnxy.hospital.mims.entity.OpDep;
import com.wnxy.hospital.mims.entity.OpDoclevel;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.service.op.impl.Op_InfoManagementServiceImpl;
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
		OpPatientinfo opPatientinfo = new OpPatientinfo("513411111111111111", "zs", 11, "男", new Date(19111111),
				new Date(), "13888888888", "ls", "13999999999", "chenedu");
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

	@Test
	public void test05() {// 添加部门信息
		Op_InfoManagementServiceImpl op_InfoManagementServiceImpl = (Op_InfoManagementServiceImpl) ac
				.getBean("op_InfoManagementServiceImpl");
		op_InfoManagementServiceImpl.addOffice("门诊部");

	}

	@Test
	public void test051() {// 查所有部门
		Op_InfoManagementServiceImpl op_InfoManagementServiceImpl = (Op_InfoManagementServiceImpl) ac
				.getBean("op_InfoManagementServiceImpl");
		System.out.println(op_InfoManagementServiceImpl.queryAllOffice());

	}

	@Test
	public void test052() {// 查指定编号的部门
		Op_InfoManagementServiceImpl op_InfoManagementServiceImpl = (Op_InfoManagementServiceImpl) ac
				.getBean("op_InfoManagementServiceImpl");
		System.out.println(op_InfoManagementServiceImpl.queryOfficeByOfficeId("7e711304f3ae48d8b33b309b4ae0613a"));

	}

	@Test
	public void test06() {// 添加科室信息
		Op_InfoManagementServiceImpl op_InfoManagementServiceImpl = (Op_InfoManagementServiceImpl) ac
				.getBean("op_InfoManagementServiceImpl");
		op_InfoManagementServiceImpl.addOpDep("内科");

	}

	@Test
	public void test061() {// 查所有科室
		Op_InfoManagementServiceImpl op_InfoManagementServiceImpl = (Op_InfoManagementServiceImpl) ac
				.getBean("op_InfoManagementServiceImpl");
		System.out.println(op_InfoManagementServiceImpl.queryAllOpDep());

	}

	@Test
	public void test062() {// 查指定编号的科室
		Op_InfoManagementServiceImpl op_InfoManagementServiceImpl = (Op_InfoManagementServiceImpl) ac
				.getBean("op_InfoManagementServiceImpl");
		System.out.println(op_InfoManagementServiceImpl.queryOpDepByDepId("31beb833020e49f2918df3d5d986b90b"));

	}

	@Test
	public void test07() {// 添加员工
		Op_InfoManagementServiceImpl op_InfoManagementServiceImpl = (Op_InfoManagementServiceImpl) ac
				.getBean("op_InfoManagementServiceImpl");
		String officeId = "319c8a544fbf4b45a1c4c7ae3e4fb29d";// 部门编号
		Office office = null;// 部门域属性
		String depId = "31beb833020e49f2918df3d5d986b90b";// 科室编号
		OpDep opDep = null;// 科室域属性
		String empName = "zs";// 员工名字
		String empIdentity = "513411111111111114";// 员工身份证号
		String empSex = "男";// 员工性别
		String empAddress = "chenadu";// 员工住址
		String empEmail = "1111@kjdf.com";// 员工电邮

		Date empBirth = new Date("1999/09/09");// 员工生日

		String empNation = "CN";// 员工国籍

		Date empHireday = new Date();// 员工入职时间

		String empPhoto = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1583351222492&di=8f5db222937e7c70c522143d7b99aafd&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F9c16fdfaaf51f3de81a9ddd89feef01f3a297976.jpg";// 员工证件照

		String empPhone = "13999999999";// 员工电话号

		Emp tempEmp = new Emp(null, officeId, office, depId, opDep, empName, empIdentity, empSex, empAddress, empEmail,
				empBirth, empNation, empHireday, empPhoto, empPhone);
		op_InfoManagementServiceImpl.addEmp(tempEmp);

	}

	@Test
	public void test071() {// 查所有员工
		Op_InfoManagementServiceImpl op_InfoManagementServiceImpl = (Op_InfoManagementServiceImpl) ac
				.getBean("op_InfoManagementServiceImpl");
		System.out.println(op_InfoManagementServiceImpl.queryAllEmp());

	}

	@Test
	public void test072() {// 查指定科室编号的员工
		Op_InfoManagementServiceImpl op_InfoManagementServiceImpl = (Op_InfoManagementServiceImpl) ac
				.getBean("op_InfoManagementServiceImpl");
		System.out.println(op_InfoManagementServiceImpl.queryEmpByDepId("31beb833020e49f2918df3d5d986b90b"));

	}

	@Test
	public void test08() {// 添加医生收费等级记录
		Op_InfoManagementServiceImpl op_InfoManagementServiceImpl = (Op_InfoManagementServiceImpl) ac
				.getBean("op_InfoManagementServiceImpl");
		String dlId = null;
		String empId = "f96f2fb706e4452cb038806763b2af2c";
		Integer level = 2;
		float price = 10.00f;
		OpDoclevel tempOpDoclevel = new OpDoclevel(dlId, empId, level, price);
		op_InfoManagementServiceImpl.addOpDoclevel(tempOpDoclevel);
	}

	@Test
	public void test081() {// 查所有收费等级，理论上要去重，同一个等级只显示一种
		Op_InfoManagementServiceImpl op_InfoManagementServiceImpl = (Op_InfoManagementServiceImpl) ac
				.getBean("op_InfoManagementServiceImpl");
		System.out.println(op_InfoManagementServiceImpl.queryAllLevel());
	}
}
