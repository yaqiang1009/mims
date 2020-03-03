package com.wnxy.hospital.mims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.EmpExample;
import com.wnxy.hospital.mims.entity.OpDep;
import com.wnxy.hospital.mims.mapper.EmpMapper;
import com.wnxy.hospital.mims.mapper.OpDepMapper;
import com.wnxy.hospital.mims.service.Ip_empService;
@Component
public class Ip_empServiceImpl implements Ip_empService{
	@Autowired
	private EmpMapper empMapper;
	@Autowired
	private OpDepMapper opDepMapper;
	//查询所有医生
	@Override
	public List<Emp> selectAllEmp() {
		EmpExample example=new EmpExample();
		List<Emp> emps = empMapper.selectByExample(example);
		//医生科室赋值
		for(Emp emp:emps) {
			OpDep dep = opDepMapper.selectByPrimaryKey(emp.getDepId());
			emp.setOpDep(dep);
		}
		return emps;
	}
	//查询指定医生
	@Override
	public Emp selectEmp(String id) {
		Emp emp = empMapper.selectByPrimaryKey(id);
		//医生科室赋值
			OpDep dep = opDepMapper.selectByPrimaryKey(emp.getDepId());
			emp.setOpDep(dep);
		return emp;
	}
}
