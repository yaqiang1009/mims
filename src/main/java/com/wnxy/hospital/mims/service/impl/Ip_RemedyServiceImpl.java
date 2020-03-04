package com.wnxy.hospital.mims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.IpBed;
import com.wnxy.hospital.mims.entity.IpRemedy;
import com.wnxy.hospital.mims.entity.IpRemedyExample;
import com.wnxy.hospital.mims.entity.IpWard;
import com.wnxy.hospital.mims.entity.OpDep;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.mapper.EmpMapper;
import com.wnxy.hospital.mims.mapper.IpBedMapper;
import com.wnxy.hospital.mims.mapper.IpRemedyMapper;
import com.wnxy.hospital.mims.mapper.IpWardMapper;
import com.wnxy.hospital.mims.mapper.OpDepMapper;
import com.wnxy.hospital.mims.mapper.OpPatientinfoMapper;
import com.wnxy.hospital.mims.service.Ip_RemedyService;
@Component
public class Ip_RemedyServiceImpl implements Ip_RemedyService{
	@Autowired
	private IpRemedyMapper ipRemedyMapper;
	@Autowired
	private OpPatientinfoMapper opPatientinfoMapper;
	@Autowired
	private EmpMapper empMapper;
	@Autowired
	private IpWardMapper ipWardMapper;
	@Autowired
	private IpBedMapper ipBedMapper;
	@Autowired
	private OpDepMapper opDepMapper;
	//查询所有医疗单
	@Override
	public List<IpRemedy> selectAllRemedy(String empId) {
		try {
			//检索医疗单
			IpRemedyExample example=new IpRemedyExample();
			//可选，指定医生的医疗单,不满足则全部医生医疗单
			if(!empId.equals("")) {
				example.createCriteria().andEmpIdEqualTo(empId);
			}
			example.createCriteria().andRemedyStatusNotEqualTo("已出院");
			List<IpRemedy> ipRemedys = ipRemedyMapper.selectByExample(example);
			//对象赋值
			for(IpRemedy remedy:ipRemedys) {
				//病人
				OpPatientinfo pt = opPatientinfoMapper.selectByPrimaryKey(remedy.getPtId());
				remedy.setOpPatientinfo(pt);
				//医生
				Emp emp = empMapper.selectByPrimaryKey(remedy.getEmpId());
				remedy.setEmp(emp);
				//病房
				IpWard ward = ipWardMapper.selectByPrimaryKey(remedy.getWardId());
				remedy.setIpWard(ward);
				//床位
				IpBed bed = ipBedMapper.selectByPrimaryKey(remedy.getBedId());
				remedy.setIpBed(bed);
			}
			return ipRemedys;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//查询指定医疗单
	@Override
	public IpRemedy selectRemedy(String id) {
		try {
			IpRemedy ipRemedy = ipRemedyMapper.selectByPrimaryKey(id);
				//对象赋值
				//病人
				OpPatientinfo pt = opPatientinfoMapper.selectByPrimaryKey(ipRemedy.getPtId());
				ipRemedy.setOpPatientinfo(pt);
				//医生
				Emp emp = empMapper.selectByPrimaryKey(ipRemedy.getEmpId());
				ipRemedy.setEmp(emp);
					//科室赋值
					OpDep dep = opDepMapper.selectByPrimaryKey(emp.getDepId());
					emp.setOpDep(dep);
				//病房
				IpWard ward = ipWardMapper.selectByPrimaryKey(ipRemedy.getWardId());
				ipRemedy.setIpWard(ward);
				//床位
				IpBed bed = ipBedMapper.selectByPrimaryKey(ipRemedy.getBedId());
				ipRemedy.setIpBed(bed);
			return ipRemedy;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//修改医疗单信息
	@Override
	public IpRemedy alertRemedy(String id, String bedId, String empId, String wardId) {
		IpRemedy ipRemedy = ipRemedyMapper.selectByPrimaryKey(id);
		//信息更改
		try {
			ipRemedy.setBedId(bedId);
			ipRemedy.setEmpId(empId);
			ipRemedy.setWardId(wardId);
			ipRemedyMapper.updateByPrimaryKey(ipRemedy);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
