package com.wnxy.hospital.mims.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.IpDrug;
import com.wnxy.hospital.mims.entity.IpDrugDetail;
import com.wnxy.hospital.mims.entity.IpDrugDetailExample;
import com.wnxy.hospital.mims.entity.IpDrugExample;
import com.wnxy.hospital.mims.entity.IpDrugExample.Criteria;
import com.wnxy.hospital.mims.entity.IpIllness;
import com.wnxy.hospital.mims.entity.IpIllnessExample;
import com.wnxy.hospital.mims.entity.IpRemedy;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.entity.PhMedicines;
import com.wnxy.hospital.mims.mapper.EmpMapper;
import com.wnxy.hospital.mims.mapper.IpDrugDetailMapper;
import com.wnxy.hospital.mims.mapper.IpDrugMapper;
import com.wnxy.hospital.mims.mapper.IpIllnessMapper;
import com.wnxy.hospital.mims.mapper.IpRemedyMapper;
import com.wnxy.hospital.mims.mapper.OpPatientinfoMapper;
import com.wnxy.hospital.mims.mapper.PhMedicinesMapper;
import com.wnxy.hospital.mims.service.Ip_DrService;
@Component
public class Ip_DrServiceImpl implements Ip_DrService {
	@Autowired
	private IpDrugMapper ipDrugMapper;
	@Autowired
	private IpDrugDetailMapper ipDrugDetailMapper;
	@Autowired
	private PhMedicinesMapper phMedicinesMapper;
	@Autowired
	private IpIllnessMapper ipIllnessMapper;	
	@Autowired
	private IpRemedyMapper ipRemedyMapper;	
	@Autowired
	private OpPatientinfoMapper opPatientinfoMapper;
	@Autowired
	private EmpMapper EmpMapper;
	//查询当日所有病人药单
	@Override
	public PageInfo<IpDrug> selectNowAllDr(int index) {
		//检索当日药单
		IpDrugExample example=new IpDrugExample();
		Criteria create = example.createCriteria();
		//获取今日时间范围
		Date nowDate=new Date();
		long time = nowDate.getTime();
		long temp = time%(1000*3600*24);
		Date date=new Date(time-temp);
		create.andDrugDateBetween(date, nowDate);
		//分页
		PageHelper.startPage(index, 2);
		List<IpDrug> ipDrugs = ipDrugMapper.selectByExample(example);
		//药单对象赋值
		for(IpDrug ipDrug:ipDrugs) {
			//明细表赋值
			IpDrugDetailExample examplede=new IpDrugDetailExample();
			examplede.createCriteria().andDrugIdEqualTo(ipDrug.getDrugId());
			List<IpDrugDetail> ipDrugDetails = ipDrugDetailMapper.selectByExample(examplede);
			//明细表药品赋值
			for(IpDrugDetail ipDrugDetail:ipDrugDetails) {
				PhMedicines phMedicines = phMedicinesMapper.selectByPrimaryKey(ipDrugDetail.getMedicineId());
				ipDrugDetail.setPhMedicines(phMedicines);
			}
			//明细表保存至药单
			ipDrug.setIpDrugDetails(ipDrugDetails);
			//病情单赋值
			IpIllness ipIllness = ipIllnessMapper.selectByPrimaryKey(ipDrug.getIllnessId());
			ipDrug.setIpIllness(ipIllness);
			//医疗单赋值
			IpRemedy ipRemedy = ipRemedyMapper.selectByPrimaryKey(ipIllness.getRemedyId());
			ipIllness.setIpRemedy(ipRemedy);
				//病人赋值
				OpPatientinfo pt = opPatientinfoMapper.selectByPrimaryKey(ipRemedy.getPtId());
				ipRemedy.setOpPatientinfo(pt);
				//医生赋值
				Emp emp = EmpMapper.selectByPrimaryKey(ipRemedy.getEmpId());
				ipRemedy.setEmp(emp);
		}
		PageInfo<IpDrug> ipDrugp=new PageInfo<>(ipDrugs);
		return ipDrugp;
	}
	//查询指定医疗单所有药单
	@Override
	public PageInfo<IpIllness> selectIpIllnesss(String id,int index) {
		//查病情单
		IpIllnessExample example=new IpIllnessExample();
		example.createCriteria().andRemedyIdEqualTo(id);
		//分页展示数量
		PageHelper.startPage(index, 2);
		List<IpIllness> IpIllnesss = ipIllnessMapper.selectByExample(example);
		//查询药单
			for(IpIllness ipIllness:IpIllnesss) {
				//获取药单
				IpDrugExample exampleill=new IpDrugExample();
				exampleill.createCriteria().andIllnessIdEqualTo(ipIllness.getIllnessId());
				List<IpDrug> IpDrugs = ipDrugMapper.selectByExample(exampleill);
				IpDrug ipDrug = IpDrugs.get(0);
				ipIllness.setIpDrug(ipDrug);
				//查询药单明细
				IpDrugDetailExample exampleDe=new IpDrugDetailExample();
				exampleDe.createCriteria().andDrugIdEqualTo((ipDrug.getDrugId()));
				List<IpDrugDetail> ipDrugDetails = ipDrugDetailMapper.selectByExample(exampleDe);
				ipDrug.setIpDrugDetails(ipDrugDetails);
				//明细药品赋值
				for(IpDrugDetail ipDrugDetail:ipDrugDetails) {
					PhMedicines phMedicines = phMedicinesMapper.selectByPrimaryKey(ipDrugDetail.getMedicineId());
					ipDrugDetail.setPhMedicines(phMedicines);
				}
			}
		PageInfo<IpIllness> IpIllnessp=new PageInfo<>(IpIllnesss);
		// TODO Auto-generated method stub
		return IpIllnessp;
	}

}
