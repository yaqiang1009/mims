package com.wnxy.hospital.mims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.IpHospitalized;
import com.wnxy.hospital.mims.entity.IpHospitalizedExample;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.mapper.EmpMapper;
import com.wnxy.hospital.mims.mapper.IpHospitalizedMapper;
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
	//检索全部住院订单
	@Override
	public List<IpHospitalized> selectAllHos() {
		//检索订单
		IpHospitalizedExample example=new IpHospitalizedExample();
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

}
