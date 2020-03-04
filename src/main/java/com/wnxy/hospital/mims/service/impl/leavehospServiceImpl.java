package com.wnxy.hospital.mims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.IpHospitalized;
import com.wnxy.hospital.mims.entity.IpLeaveapply;
import com.wnxy.hospital.mims.entity.IpLeaveapplyExample;
import com.wnxy.hospital.mims.entity.IpRemedy;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.mapper.EmpMapper;
import com.wnxy.hospital.mims.mapper.IpHospitalizedMapper;
import com.wnxy.hospital.mims.mapper.IpLeaveapplyMapper;
import com.wnxy.hospital.mims.mapper.IpRemedyMapper;
import com.wnxy.hospital.mims.mapper.OpPatientinfoMapper;
import com.wnxy.hospital.mims.service.leavehospService;
@Component
public class leavehospServiceImpl implements leavehospService{
	@Autowired
	private IpLeaveapplyMapper ipLeaveapplyMapper;
	@Autowired
	private IpRemedyMapper ipRemedyMapper;
	@Autowired
	private OpPatientinfoMapper opPatientinfoMapper;
	@Autowired
	private EmpMapper empMapper;
	//检索所有出院申请
	@Override
	public List<IpLeaveapply> selectAllLeave() {
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
	}
	@Override
	public void leavePass(String id) {
		System.out.println(id);
		IpLeaveapply ipLeaveapply = ipLeaveapplyMapper.selectByPrimaryKey(id);
		ipLeaveapply.setResult("同意");
		try {
			ipLeaveapplyMapper.updateByPrimaryKey(ipLeaveapply);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
