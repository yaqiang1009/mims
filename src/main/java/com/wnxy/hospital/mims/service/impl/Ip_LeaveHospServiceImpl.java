package com.wnxy.hospital.mims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.IpHospitalized;
import com.wnxy.hospital.mims.entity.IpLeaveapply;
import com.wnxy.hospital.mims.entity.IpLeaveapplyExample;
import com.wnxy.hospital.mims.entity.IpRemedy;
import com.wnxy.hospital.mims.entity.OpDep;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.mapper.EmpMapper;
import com.wnxy.hospital.mims.mapper.IpHospitalizedMapper;
import com.wnxy.hospital.mims.mapper.IpLeaveapplyMapper;
import com.wnxy.hospital.mims.mapper.IpRemedyMapper;
import com.wnxy.hospital.mims.mapper.OpDepMapper;
import com.wnxy.hospital.mims.mapper.OpPatientinfoMapper;
import com.wnxy.hospital.mims.service.Ip_LeaveHospService;
@Component
public class Ip_LeaveHospServiceImpl implements Ip_LeaveHospService{
	@Autowired
	private IpLeaveapplyMapper ipLeaveapplyMapper;
	@Autowired
	private IpRemedyMapper ipRemedyMapper;
	@Autowired
	private OpPatientinfoMapper opPatientinfoMapper;
	@Autowired
	private EmpMapper empMapper;
	@Autowired
	private OpDepMapper opDepMapper;
	//检索所有出院申请
	@Override
	public List<IpLeaveapply> selectAllLeave() {
		try {
			IpLeaveapplyExample example=new IpLeaveapplyExample();
			example.createCriteria().andResultEqualTo("申请中");
			List<IpLeaveapply> IpLeaveapplys = ipLeaveapplyMapper.selectByExample(example);
			//赋值
			for(IpLeaveapply le:IpLeaveapplys) {
				//医疗单
				IpRemedy ipRemedy = ipRemedyMapper.selectByPrimaryKey(le.getRemedyId());
					//病人
				OpPatientinfo pt = opPatientinfoMapper.selectByPrimaryKey(ipRemedy.getPtId());
				ipRemedy.setOpPatientinfo(pt);
				le.setIpRemedy(ipRemedy);
				//医生
				Emp emp = empMapper.selectByPrimaryKey(le.getEmpId());
				le.setEmp(emp);
			}
			return IpLeaveapplys;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//出院申请通过，修改数据库
	@Transactional
	@Override
	public void leavePass(String id) {
		//修改申请单对象数据
		IpLeaveapply ipLeaveapply = ipLeaveapplyMapper.selectByPrimaryKey(id);
		ipLeaveapply.setResult("同意");
		//修改医疗单对象数据
		IpRemedy ipRemedy = ipRemedyMapper.selectByPrimaryKey(ipLeaveapply.getRemedyId());
		ipRemedy.setRemedyStatus("已出院");
		try {
			//调用，修改数据库
			//修改出院申请单信息为同意
			ipLeaveapplyMapper.updateByPrimaryKey(ipLeaveapply);
			//修改医疗单状态为已出院
			ipRemedyMapper.updateByPrimaryKey(ipRemedy);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//检索指定医疗单
	@Override
	public IpLeaveapply selectLeave(String hosid) {
		try {
			IpLeaveapply ipLeaveapply = ipLeaveapplyMapper.selectByPrimaryKey(hosid);
			//赋值
				//医疗单
				IpRemedy ipRemedy = ipRemedyMapper.selectByPrimaryKey
						(ipLeaveapply.getRemedyId());
					//病人
					OpPatientinfo pt = opPatientinfoMapper.
							selectByPrimaryKey(ipRemedy.getPtId());
					ipRemedy.setOpPatientinfo(pt);
				ipLeaveapply.setIpRemedy(ipRemedy);
				//医生
				Emp emp = empMapper.selectByPrimaryKey(ipLeaveapply.getEmpId());
					//科室赋值
					OpDep dep = opDepMapper.selectByPrimaryKey(emp.getDepId());
					emp.setOpDep(dep);
				ipLeaveapply.setEmp(emp);
			return ipLeaveapply;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//出院申请未通过，修改数据库
	@Transactional
	@Override
	public void leaveReject(String id, String remarks) {
		//修改申请单对象数据
		IpLeaveapply ipLeaveapply = ipLeaveapplyMapper.selectByPrimaryKey(id);
		ipLeaveapply.setResult("不同意");
		ipLeaveapply.setRemarks(remarks);
		//修改医疗单对象数据
		IpRemedy ipRemedy = ipRemedyMapper.selectByPrimaryKey(ipLeaveapply.getRemedyId());
		ipRemedy.setRemedyStatus("住院中");
		try {
			//调用，修改数据库
			//修改出院申请单信息为同意
			ipLeaveapplyMapper.updateByPrimaryKey(ipLeaveapply);
			//修改医疗单状态为已出院
			ipRemedyMapper.updateByPrimaryKey(ipRemedy);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
