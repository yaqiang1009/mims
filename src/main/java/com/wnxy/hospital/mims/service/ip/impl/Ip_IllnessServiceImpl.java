package com.wnxy.hospital.mims.service.ip.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.IpBed;
import com.wnxy.hospital.mims.entity.IpIllness;
import com.wnxy.hospital.mims.entity.IpIllnessExample;
import com.wnxy.hospital.mims.entity.IpRemedy;
import com.wnxy.hospital.mims.entity.IpWard;
import com.wnxy.hospital.mims.entity.OpDep;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.mapper.EmpMapper;
import com.wnxy.hospital.mims.mapper.IpBedMapper;
import com.wnxy.hospital.mims.mapper.IpIllnessMapper;
import com.wnxy.hospital.mims.mapper.IpRemedyMapper;
import com.wnxy.hospital.mims.mapper.IpWardMapper;
import com.wnxy.hospital.mims.mapper.OpDepMapper;
import com.wnxy.hospital.mims.mapper.OpPatientinfoMapper;
import com.wnxy.hospital.mims.service.ip.Ip_IllnessService;
/**
 * 住院就诊病情单相关
 * @author Administrator
 *
 */
@Component
public class Ip_IllnessServiceImpl implements Ip_IllnessService {
	@Autowired
	IpIllnessMapper ipIllnessMapper;
	@Autowired
	IpRemedyMapper ipRemedyMapper;
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
	
	//开具病情单
	@Override
	public String addIllnessOrder(IpIllness ipIllness,String remedyId) {
		//接收页面传的对象
		//生成主键
		ipIllness.setIllnessId(ipIllness.getIllnessId());
		//插入时日期
		ipIllness.setIllnessDate(new Date());
		//外键id
		ipIllness.setRemedyId(remedyId);
		try {
			ipIllnessMapper.insert(ipIllness);
			return "插入成功";
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
			return "插入失败";
		}
	}

	//修改开具的病情单，但是时间应该是不能修改的
	@Override
	public String updateIllnessOrder(IpIllness ipIllness) {
		try {
			//方法为只修改参数不为空的字段，网页传过来时不把日期传过来就可以
			int updateCount = ipIllnessMapper.updateByPrimaryKeySelective(ipIllness);
			//没有异常也要判断数据库是否真的被修改
			if(updateCount==0) {
				return "修改失败";
			}
			return "修改成功";
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
			return "修改失败";
		}
	}

	//查询所有病情单，一张医疗单对应多张病情单
	@Override
	public PageInfo<IpIllness> selectAllIpIllnessByRemedyId(String remedyId,int index) {
		try {
			//设置分页
			PageHelper.startPage(index, 6);
			//查询
			List<IpIllness> allillness = ipIllnessMapper.selectByRemedyId(remedyId);
			for(IpIllness ipIllness:allillness) {
				//医疗单对象
				IpRemedy ipRemedy = ipRemedyMapper.selectByPrimaryKey(ipIllness.getRemedyId());
				ipIllness.setIpRemedy(ipRemedy);
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
			}
			PageInfo<IpIllness> list=new PageInfo<>(allillness);
			return list;
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
			return null;
		}
	}
	
	//查询单张病情单详情
	@Override
	public IpIllness selectIpIllnessById(String illnessId) {
		IpIllness ipIllness = ipIllnessMapper.selectByPrimaryKey(illnessId);
		//医疗单对象赋值，多表
		IpRemedy ipRemedy = ipRemedyMapper.selectByPrimaryKey(ipIllness.getRemedyId());
		ipIllness.setIpRemedy(ipRemedy);
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
		return ipIllness;
	}


}
