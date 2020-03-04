package com.wnxy.hospital.mims.service;

import java.util.ArrayList;
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
import com.wnxy.hospital.mims.entity.IpDrug;
import com.wnxy.hospital.mims.entity.IpDrugDetail;
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
import com.wnxy.hospital.mims.mapper.IpDrugDetailMapper;
import com.wnxy.hospital.mims.mapper.IpHospitalizedMapper;
import com.wnxy.hospital.mims.mapper.IpRemedyMapper;
import com.wnxy.hospital.mims.mapper.IpWardMapper;
import com.wnxy.hospital.mims.mapper.OfficeMapper;
import com.wnxy.hospital.mims.mapper.OpDepMapper;
import com.wnxy.hospital.mims.mapper.OpPatientinfoMapper;
import com.wnxy.hospital.mims.service.impl.Op_Ip_OrderImpl;
import com.wnxy.hospital.mims.service.ip.impl.Ip_DrugDetailServiceImpl;
import com.wnxy.hospital.mims.service.ip.impl.Ip_DrugServiceImpl;
import com.wnxy.hospital.mims.service.ip.impl.Ip_IllnessServiceImpl;
import com.wnxy.hospital.mims.service.ip.impl.Ph_Ip_OderStatusImpl;

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
		ipIllness.setIllness("好了");
		ipIllness.setCaution("不吃");
		ip_IllnessServiceImpl.addIllnessOrder(ipIllness,"66e33789f0a84e7985ce748015e4b5df");
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
	//查询所有病情订单service
	@Test
	public void ip_IllnessServiceImplText03() {
		Ip_IllnessServiceImpl ip_IllnessServiceImpl = (Ip_IllnessServiceImpl) ac.getBean("ip_IllnessServiceImpl");
		//参数为医疗单id
		List<IpIllness> list = ip_IllnessServiceImpl.selectAllIpIllnessByRemedyId("66e33789f0a84e7985ce748015e4b5df");
		for(IpIllness ipIllness : list) {
			System.out.println(ipIllness);
		}
	}
	//查询病情订单详情service
	@Test
	public void ip_IllnessServiceImplText04() {
		Ip_IllnessServiceImpl ip_IllnessServiceImpl = (Ip_IllnessServiceImpl) ac.getBean("ip_IllnessServiceImpl");
		//参数为医疗单id
		IpIllness ipIllness = ip_IllnessServiceImpl.selectIpIllnessById("2");
		System.out.println(ipIllness);
	}
	
	//添加药单详情订单service
	@Test
	public void Ip_DrugDetailServiceImplText01() {
		Ip_DrugDetailServiceImpl ip_DrugDetailServiceImpl = (Ip_DrugDetailServiceImpl) ac.getBean("ip_DrugDetailServiceImpl");
		IpDrugDetail i1 =new IpDrugDetail();
		IpDrugDetail i2 =new IpDrugDetail();
		IpDrugDetail i3 =new IpDrugDetail();
		i1.setDrugNum(2);
		i1.setMedicineId("1");
		i1.setPrice(12.0);
		i1.setUseInstructions("一日一次");
		i2.setDrugNum(4);
		i2.setMedicineId("2");
		i2.setPrice(24.0);
		i2.setUseInstructions("一日二次");
		i3.setDrugNum(6);
		i3.setMedicineId("3");
		i3.setPrice(6.0);
		i3.setUseInstructions("一日三次");
		List<IpDrugDetail> ipDrugDetails= new ArrayList<IpDrugDetail>();
		ipDrugDetails.add(i1);
		ipDrugDetails.add(i2);
		ipDrugDetails.add(i3);
		ip_DrugDetailServiceImpl.addDrugDetailOrder(ipDrugDetails, "2");
	}
	//查询药单详情订单service
	@Test
	public void Ip_DrugDetailServiceImplText02() {
		Ip_DrugDetailServiceImpl ip_DrugDetailServiceImpl = (Ip_DrugDetailServiceImpl) ac.getBean("ip_DrugDetailServiceImpl");
		List<IpDrugDetail> lists = ip_DrugDetailServiceImpl.selectAllDrugDetailsByDrugId("2");
		for(IpDrugDetail ipDrugDetail:lists) {
			System.out.println(ipDrugDetail);
		}
	}
	//删除整张药单详情订单dao
	@Test
	public void Ip_DrugDetailDaoText03() {
		IpDrugDetailMapper ipDrugDetailMapper =(IpDrugDetailMapper) ac.getBean("ipDrugDetailMapper");
		ipDrugDetailMapper.deleteByDrugId("1");
	}
	
	//查询指定医生医疗单测试
	@Test
	public void selectAllRemedyText() {
		Ip_RemedyService ip_RemedyService = (Ip_RemedyService)ac.getBean("ip_RemedyServiceImpl");
		List<IpRemedy> allRemedy = ip_RemedyService.selectAllRemedy("11822dc20ca643f0ad602e8fecd57c21");
		System.out.println(allRemedy);
	}
	
	/*
	 * //药单详情订单获取总价Service
	 * 
	 * @Test public void Ip_DrugDetailServiceImplText04() { Ip_DrugDetailServiceImpl
	 * ip_DrugDetailServiceImpl = (Ip_DrugDetailServiceImpl)
	 * ac.getBean("ip_DrugDetailServiceImpl"); Double priceTotal =
	 * ip_DrugDetailServiceImpl.getPriceTotal("2"); System.out.println(priceTotal);
	 * }
	 */
	
	/*
	 * //修改药单总价Service
	 * 
	 * @Test public void Ip_DrugServiceImplText01() { Ip_DrugServiceImpl
	 * ip_DrugServiceImpl = (Ip_DrugServiceImpl) ac.getBean("ip_DrugServiceImpl");
	 * ip_DrugServiceImpl.updateDrugTotalPriceTotal("1", 111.0); }
	 */
	
	//添加药单订单service
	@Test
	public void Ip_DrugServiceImplText01() {
		Ip_DrugServiceImpl ip_DrugServiceImpl = (Ip_DrugServiceImpl) ac.getBean("ip_DrugServiceImpl");
		IpDrug ipDrug=new IpDrug();
		ip_DrugServiceImpl.addDrugOrder(ipDrug, "858508a5d25f427491381992b9e26781");
	}
	//作废药单订单service
	@Test
	public void Ip_DrugServiceImplText02() {
		Ip_DrugServiceImpl ip_DrugServiceImpl = (Ip_DrugServiceImpl) ac.getBean("ip_DrugServiceImpl");
		IpDrug ipDrug=new IpDrug();
		ipDrug.setDrugId("3");
		String msg = ip_DrugServiceImpl.deleteDrugStatus(ipDrug);
		System.out.println(msg);
	}
	//修改药单状态测试单模块service
	@Test
	public void Ip_DrugServiceImplText03() {
		Ph_Ip_OderStatusImpl ph_Ip_OderStatusImpl = (Ph_Ip_OderStatusImpl) ac.getBean("ph_Ip_OderStatusImpl");
		IpDrug ipDrug=new IpDrug();
		//String msg = ip_DrugServiceImpl.updateDrugStatusWithPrice(ipDrug, 1);
		String msg = ph_Ip_OderStatusImpl.updateDrugStatusToPh("1");
		System.out.println(msg);
	}
	//查询药单
	@Test
	public void Ip_DrugDetailDaoText04() {
		Ip_DrugServiceImpl ip_DrugServiceImpl = (Ip_DrugServiceImpl) ac.getBean("ip_DrugServiceImpl");
		IpDrug drugId = ip_DrugServiceImpl.selectDrugByDrugId("2");
		System.out.println(drugId);
	}
}
