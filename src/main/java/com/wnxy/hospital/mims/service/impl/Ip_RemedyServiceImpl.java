package com.wnxy.hospital.mims.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.IpBed;
import com.wnxy.hospital.mims.entity.IpHospitalized;
import com.wnxy.hospital.mims.entity.IpIllness;
import com.wnxy.hospital.mims.entity.IpRemedy;
import com.wnxy.hospital.mims.entity.IpRemedyExample;
import com.wnxy.hospital.mims.entity.IpRemedyExample.Criteria;
import com.wnxy.hospital.mims.entity.IpWard;
import com.wnxy.hospital.mims.entity.OpDep;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.entity.OpPatientinfoExample;
import com.wnxy.hospital.mims.mapper.EmpMapper;
import com.wnxy.hospital.mims.mapper.IpBedMapper;
import com.wnxy.hospital.mims.mapper.IpIllnessMapper;
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
	@Autowired
	IpIllnessMapper ipIllnessMapper;
	//查询所有医疗单
	@Override
	public PageInfo<IpRemedy> selectAllRemedy(String empId,int index) {
		try {
			//设置分页
			PageHelper.startPage(index, 6);
			//检索医疗单
			IpRemedyExample example=new IpRemedyExample();
			//可选，指定医生的医疗单,不满足则全部医生医疗单
			Criteria create = example.createCriteria();
			if(!empId.equals("")) {
				create.andEmpIdEqualTo(empId);
			}
			create.andRemedyStatusNotEqualTo("已出院");
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
			PageInfo<IpRemedy> ipRemedyp=new PageInfo<>(ipRemedys);
			return ipRemedyp;
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
	//模糊查询病人医疗单
	@Override
	public PageInfo<IpRemedy> selectAllRemedyPtName(String ptName) {
		try {
			//设置分页
			PageHelper.startPage(1, 100);
			OpPatientinfoExample examplept=new OpPatientinfoExample();
			examplept.createCriteria().andPtNameLike("%"+ptName+"%");
			//查询病人
			List<OpPatientinfo> pts = opPatientinfoMapper.selectByExample(examplept);
			//获取病人id集合
			List<String> values=new ArrayList<String>();
			values.add("");
			for(OpPatientinfo pt:pts) {
				values.add(pt.getPtId());
			}
			//检索满足集合的医疗单
			IpRemedyExample example=new IpRemedyExample();
			Criteria create = example.createCriteria();
			create.andPtIdIn(values);
			create.andRemedyStatusNotEqualTo("已出院");
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
			PageInfo<IpRemedy> ipRemedyp=new PageInfo<>(ipRemedys);
			return ipRemedyp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//查询历史所有医疗单
	@Override
	public PageInfo<IpRemedy> selectHisAllRemedy(String ptName, int index) {
		try {
			//检索医疗单
			IpRemedyExample example=new IpRemedyExample();
			//可选，指定病人的医疗单,不满足则全部医生医疗单
			Criteria create = example.createCriteria();
			if(!ptName.equals("")) {
				OpPatientinfoExample examplePt=new OpPatientinfoExample();
				examplePt.createCriteria().andPtNameLike("%"+ptName+"%");
				List<OpPatientinfo> pts = opPatientinfoMapper.selectByExample(examplePt);
				//条件，集合中病人的医疗单
				List<String> values=new ArrayList<String>();
				values.add("");
				for(OpPatientinfo opPatientinfo:pts) {
					values.add(opPatientinfo.getPtId());
				}
				create.andPtIdIn(values);
			}
			//设置分页
			PageHelper.startPage(index, 8);
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
			PageInfo<IpRemedy> ipRemedyp=new PageInfo<>(ipRemedys);
			return ipRemedyp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//只查询尚在住院状态的医疗单
	@Override
	public PageInfo<IpRemedy> selectSomeRemedy(String empId,int index){
		try {
			//设置分页
			PageHelper.startPage(index, 6);
			//检索医疗单
			IpRemedyExample example=new IpRemedyExample();
			//可选，指定医生的医疗单,不满足则全部医生医疗单
			Criteria create = example.createCriteria();
			if(!empId.equals("")) {
				create.andEmpIdEqualTo(empId);
			}
			//只查询住院中状态
			create.andRemedyStatusEqualTo("住院中");
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
				//查询最新的病情单
				IpIllness illness = ipIllnessMapper.selectOneByRemedyId(remedy.getRemedyId());
				remedy.setIpIllness(illness);
			}
			PageInfo<IpRemedy> ipRemedyp=new PageInfo<>(ipRemedys);
			return ipRemedyp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
