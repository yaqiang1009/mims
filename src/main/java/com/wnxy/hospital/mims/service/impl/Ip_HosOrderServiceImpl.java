package com.wnxy.hospital.mims.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.IpHospitalized;
import com.wnxy.hospital.mims.entity.IpHospitalizedExample;
import com.wnxy.hospital.mims.entity.IpRemedy;
import com.wnxy.hospital.mims.entity.OpDep;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.mapper.EmpMapper;
import com.wnxy.hospital.mims.mapper.IpHospitalizedMapper;
import com.wnxy.hospital.mims.mapper.IpRemedyMapper;
import com.wnxy.hospital.mims.mapper.OpDepMapper;
import com.wnxy.hospital.mims.mapper.OpPatientinfoMapper;
import com.wnxy.hospital.mims.service.Ip_HosOrderService;
//住院订单相关
@Component
public class Ip_HosOrderServiceImpl implements Ip_HosOrderService{
	@Autowired
	private IpHospitalizedMapper ipHospitalizedMapper;
	@Autowired
	private OpPatientinfoMapper opPatientinfoMapper;
	@Autowired
	private EmpMapper empMapper;
	@Autowired
	private OpDepMapper opDepMapper;
	@Autowired
	private IpRemedyMapper ipRemedyMapper;
	//检索全部住院订单
	@Override
	public List<IpHospitalized> selectAllHos() {
		//检索订单
		IpHospitalizedExample example=new IpHospitalizedExample();
		example.createCriteria().andHosOrderEqualTo("申请中");
		List<IpHospitalized> ipHospitalized = ipHospitalizedMapper.selectByExample(example);
		//对象赋值
		for(IpHospitalized hos:ipHospitalized) {
			//病人对象赋值
			OpPatientinfo ptentity = opPatientinfoMapper.selectByPrimaryKey(hos.getPtId());
			hos.setPtentity(ptentity);
			//医生对象赋值
			Emp empentity = empMapper.selectByPrimaryKey(hos.getEmpId());
			hos.setEmpentity(empentity);
		}
		return ipHospitalized;
	}
	@Override
	public IpHospitalized selectHos(String id) {
		//检索订单
		IpHospitalized ipHospitalized = ipHospitalizedMapper.selectByPrimaryKey(id);
		//对象赋值
			//病人对象赋值
			OpPatientinfo ptentity = opPatientinfoMapper.selectByPrimaryKey(ipHospitalized.getPtId());
			ipHospitalized.setPtentity(ptentity);
			//医生对象赋值
			Emp empentity = empMapper.selectByPrimaryKey(ipHospitalized.getEmpId());
			//医生科室赋值
			OpDep dep = opDepMapper.selectByPrimaryKey(empentity.getDepId());
			empentity.setOpDep(dep);
			ipHospitalized.setEmpentity(empentity);
		return ipHospitalized;
	}
	//审核订单，更新数据库
	@Override
	public void updata(IpHospitalized hos) {
		try {
			ipHospitalizedMapper.updateByPrimaryKey(hos);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("系统维护中");
		}
	}
	@Transactional
	@Override
	public void overOrder(String id, String empId, String wardId, String bedId) {
		try {
		//修改住院订单状态
			//查询
			IpHospitalized ipHospitalized = ipHospitalizedMapper.selectByPrimaryKey(id);
			String ptId=ipHospitalized.getPtId();
			//修改信息
			ipHospitalized.setHosOrder("已住院");
			//更新数据库
			ipHospitalizedMapper.updateByPrimaryKey(ipHospitalized);
		//添加医疗订单
			String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
			IpRemedy remedy=new IpRemedy(uuid, id, ipHospitalized, wardId, null, bedId, null, ptId, null, empId, null, new Date(), "住院中");
			ipRemedyMapper.insert(remedy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("系统维护中");
		}
	}

}
