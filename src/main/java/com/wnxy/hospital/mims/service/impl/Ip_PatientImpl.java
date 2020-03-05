package com.wnxy.hospital.mims.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.IpHospitalized;
import com.wnxy.hospital.mims.entity.IpRemedy;
import com.wnxy.hospital.mims.entity.IpRemedyExample;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.entity.OpPatientinfoExample;
import com.wnxy.hospital.mims.mapper.IpRemedyMapper;
import com.wnxy.hospital.mims.mapper.OpPatientinfoMapper;
import com.wnxy.hospital.mims.service.Ip_Patient;
@Component
public class Ip_PatientImpl implements Ip_Patient {
	@Autowired
	private OpPatientinfoMapper opPatientinfoMapper;
	@Autowired
	private IpRemedyMapper ipRemedyMapper;
	//查询所有住院病人
	@Override
	public PageInfo<OpPatientinfo> selectNowPatient(int index) {
		//设置分页
		//条件
		//检索医疗单(住院病人)
		IpRemedyExample example=new IpRemedyExample();
		example.createCriteria().andRemedyStatusNotEqualTo("已出院");
		List<IpRemedy> ipRemedys = ipRemedyMapper.selectByExample(example);
		//获取病人集合
		List<String> values=new ArrayList<String>();
		for(IpRemedy remedy:ipRemedys) {
			values.add(remedy.getPtId());
		}
		PageHelper.startPage(index, 6);
		//获取集合中病人信息
		OpPatientinfoExample example1=new OpPatientinfoExample();
		example1.createCriteria().andPtIdIn(values);
		List<OpPatientinfo> pts = opPatientinfoMapper.selectByExample(example1);
		PageInfo<OpPatientinfo> ptp=new PageInfo<>(pts);
		return ptp;
	}
	//查询指定病人
	@Override
	public OpPatientinfo selectNowPtId(String id) {
		OpPatientinfo pt = opPatientinfoMapper.selectByPrimaryKey(id);
		return pt;
	}
	//修改病人信息
	@Override
	public OpPatientinfo alterPt(String id, String phone, String familyperson, String familyphone, String address) {
		//检索病人信息
		OpPatientinfo pt = opPatientinfoMapper.selectByPrimaryKey(id);
		//赋值修改
		pt.setPhone(phone);
		pt.setFamilyperson(familyperson);
		pt.setFamilyphone(familyphone);
		pt.setAddress(address);
		try {
			opPatientinfoMapper.updateByPrimaryKey(pt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
