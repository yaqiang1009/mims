package com.wnxy.hospital.mims.service.op.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.EmpExample;
import com.wnxy.hospital.mims.entity.IpRemedy;
import com.wnxy.hospital.mims.entity.Office;
import com.wnxy.hospital.mims.entity.OfficeExample;
import com.wnxy.hospital.mims.entity.OfficeExample.Criteria;
import com.wnxy.hospital.mims.entity.OpDep;
import com.wnxy.hospital.mims.entity.OpDepExample;
import com.wnxy.hospital.mims.entity.OpDoclevel;
import com.wnxy.hospital.mims.entity.OpDoclevelExample;
import com.wnxy.hospital.mims.mapper.EmpMapper;
import com.wnxy.hospital.mims.mapper.OfficeMapper;
import com.wnxy.hospital.mims.mapper.OpDepMapper;
import com.wnxy.hospital.mims.mapper.OpDoclevelMapper;
import com.wnxy.hospital.mims.service.op.Op_InfoManagementService;

@Service
public class Op_InfoManagementServiceImpl implements Op_InfoManagementService {
	@Autowired
	OfficeMapper officeMapper;
	@Autowired
	OpDepMapper opDepMapper;
	@Autowired
	EmpMapper empMapper;
	@Autowired
	OpDoclevelMapper opDoclevelMapper;

	// Emp员工表操作
	@Override
	public void addEmp(Emp emp) {
		List<Emp> emps = queryEmpByEmpIdentity(emp.getEmpIdentity());
		try {
			if (emps.size() == 0) {

				String officeId = emp.getOfficeId();// 部门编号
				Office office = null;// 部门域属性
				String depId = emp.getDepId();// 科室编号
				OpDep opDep = null;// 科室域属性
				String empName = emp.getEmpName();// 员工名字
				String empIdentity = emp.getEmpIdentity();// 员工身份证号
				String empSex = emp.getEmpSex();// 员工性别
				String empAddress = emp.getEmpAddress();// 员工住址
				String empEmail = emp.getEmpEmail();// 员工电邮

				Date empBirth = emp.getEmpBirth();// 员工生日

				String empNation = emp.getEmpNation();// 员工国籍

				Date empHireday = emp.getEmpHireday();// 员工入职时间

				String empPhoto = emp.getEmpPhoto();// 员工证件照

				String empPhone = emp.getEmpPhone();// 员工电话号

				Emp tempEmp = new Emp(null, officeId, office, depId, opDep, empName, empIdentity, empSex, empAddress,
						empEmail, empBirth, empNation, empHireday, empPhoto, empPhone);
				String empIdUUID = UUID.randomUUID().toString().replace("-", "").trim().toString();// 员工编号
				tempEmp.setEmpId(empIdUUID);// 员工编号用UUID
				empMapper.insertSelective(tempEmp);// 因为Emp实体有域属性因此选择性添加
			} else {
				throw new RuntimeException("添加员工信息失败，请勿重复添加");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("添加员工信息失败");
		}

	}// 添加员工信息

	@Override
	public List<Emp> queryAllEmp() {
		EmpExample example = new EmpExample();
		com.wnxy.hospital.mims.entity.EmpExample.Criteria criteria = example.createCriteria();
		criteria.andEmpIdIsNotNull();

		return empMapper.selectByExample(example);

	}// 查询所有员工

	@Override
	public Emp queryEmpByEmpId(String empId) {
		return empMapper.selectByPrimaryKey(empId);

	}// 根据员工编号查询指定员工

	@Override
	public List<Emp> queryEmpByEmpIdentity(String empIdentity) {
		EmpExample example = new EmpExample();
		com.wnxy.hospital.mims.entity.EmpExample.Criteria criteria = example.createCriteria();
		criteria.andEmpIdentityEqualTo(empIdentity);
		return empMapper.selectByExample(example);
	}// 查询指定身份证的员工

	@Override
	public List<Emp> queryEmpByDepId(String depId) {
		EmpExample example = new EmpExample();
		com.wnxy.hospital.mims.entity.EmpExample.Criteria criteria = example.createCriteria();
		criteria.andDepIdEqualTo(depId);
		return empMapper.selectByExample(example);

	}// 查询指定科室depId下的员工,未加分页

//	@Override
//	public PageInfo<Emp> queryEmpByDepId(String depId, int index) {
//		//设置分页
//		PageHelper.startPage(index, 6);
//		EmpExample example = new EmpExample();
//		com.wnxy.hospital.mims.entity.EmpExample.Criteria criteria = example.createCriteria();
//		criteria.andDepIdEqualTo(depId);
//		List<Emp> emps= empMapper.selectByExample(example);
//		PageInfo<Emp> op_pageInfo=new PageInfo<>(emps);
//		return op_pageInfo;
//	}// 查询指定科室depId下的员工，加分页

	@Override
	public List<Emp> queryEmpByOfficeId(String officeId) {
		EmpExample example = new EmpExample();
		com.wnxy.hospital.mims.entity.EmpExample.Criteria criteria = example.createCriteria();
		criteria.andDepIdEqualTo(officeId);
		return empMapper.selectByExample(example);
	}// 查询指定部门officeId下的员工

	@Override
	public void delEmpByEmpId(String empId) {
		empMapper.deleteByPrimaryKey(empId);
	}// 根据empdId删除指定员工

	@Override
	public void updateEmpByEmpId(Emp emp) {
		empMapper.updateByPrimaryKey(emp);
	}// 根据empId修改指定员工信息

	// OpDep门诊科室表操作
	@Override
	public void addOpDep(String depName) throws RuntimeException {
		List<OpDep> deps = queryOpDepByDepName(depName);

		if (deps.size() == 0) {
			OpDep tempDep = new OpDep(UUID.randomUUID().toString().replace("-", "").trim().toString(), depName);
			opDepMapper.insert(tempDep);
		} else {
			throw new RuntimeException("添加失败，请勿重复添加科室");
		}

	}// 添加科室信息

	@Override
	public List<OpDep> queryAllOpDep() {
		OpDepExample example = new OpDepExample();
		com.wnxy.hospital.mims.entity.OpDepExample.Criteria criteria = example.createCriteria();
		criteria.andDepIdIsNotNull();
		return opDepMapper.selectByExample(example);
	}// 查询所有门诊科室

	@Override
	public OpDep queryOpDepByDepId(String depId) {
		return opDepMapper.selectByPrimaryKey(depId);

	}// 根据科室编号查询指定科室

	@Override
	public List<OpDep> queryOpDepByDepName(String depName) {
		OpDepExample example = new OpDepExample();
		com.wnxy.hospital.mims.entity.OpDepExample.Criteria criteria = example.createCriteria();
		criteria.andDepNameEqualTo(depName);
		return opDepMapper.selectByExample(example);
	}// 根据科室名称查询科室

	@Override
	public void delOpDepByDepId(String depId) {
		opDepMapper.deleteByPrimaryKey(depId);
	}// 根据depId删除指定科室

	@Override
	public void updateOpDepByDepId(OpDep opDep) {
		opDepMapper.updateByPrimaryKey(opDep);
	}// 根据depId修改指定科室信息

	// Office表操作
	@Override
	public void addOffice(String officeName) throws RuntimeException {
		List<Office> offices = queryOfficeByOfficeName(officeName);

		if (offices.size() == 0) {// 不允许重复添加
			Office tempOffice = new Office(UUID.randomUUID().toString().replace("-", "").trim().toString(), officeName);
			officeMapper.insert(tempOffice);
		} else {
			throw new RuntimeException("添加部门信息失败，请勿重复添加部门");
		}

	}// 添加部门信息

	@Override
	public List<Office> queryAllOffice() {
		OfficeExample example = new OfficeExample();
		Criteria criteria = example.createCriteria();
		criteria.andOfficeIdIsNotNull();
		return officeMapper.selectByExample(example);

	}// 查询所有部门

	@Override
	public Office queryOfficeByOfficeId(String officeId) {
		return officeMapper.selectByPrimaryKey(officeId);

	}// 根据部门编号查询指定部门

	@Override
	public List<Office> queryOfficeByOfficeName(String officeName) {
		OfficeExample example = new OfficeExample();
		Criteria criteria = example.createCriteria();
		criteria.andOfficeNameEqualTo(officeName);
		return officeMapper.selectByExample(example);

	}// 根据部门名称查询部门

	@Override
	public void delOfficeByOfficeId(String officeId) {
		officeMapper.deleteByPrimaryKey(officeId);
	}// 根据OfficeId删除指定部门

	@Override
	public void updateOfficeByOfficeId(Office office) {
		officeMapper.updateByPrimaryKey(office);
	}// 根据officeId修改指定部门信息

	// 医生挂号费等级表OpDoclevel操作
	@Override
	public void addOpDoclevel(OpDoclevel opDoclevel) throws RuntimeException {
		List<OpDoclevel> opDoclevels = queryOpDoclevelByEmpId(opDoclevel.getEmpId());// 通过员工编号验证，一个员工只允许有1条收费等级，不允许重复添加

		if (opDoclevels.size() == 0) {
			OpDoclevel tempOpDoclevel = new OpDoclevel(UUID.randomUUID().toString().replace("-", "").trim().toString(),
					opDoclevel.getEmpId(), opDoclevel.getLevel(), opDoclevel.getPrice());
			opDoclevelMapper.insert(tempOpDoclevel);
		} else {
			throw new RuntimeException("添加医生挂号收费标准失败，同一医生请勿重复添加");
		}

	}// 添加挂号费等级信息

	@Override
	public List<OpDoclevel> queryAllOpDoclevel() {
		OpDoclevelExample example = new OpDoclevelExample();
		com.wnxy.hospital.mims.entity.OpDoclevelExample.Criteria criteria = example.createCriteria();
		criteria.andDlIdIsNotNull();
		return opDoclevelMapper.selectByExample(example);

	}// 查询所有挂号费等级信息

	@Override
	public List<Integer> queryAllLevel() {
		List<OpDoclevel> opDoclevels = opDoclevelMapper.selectAllLevel();
		List<Integer> levels = new ArrayList<Integer>();
		if (opDoclevels.size() != 0) {
			for (int i = 0; i < opDoclevels.size(); i++) {
				levels.add(i, opDoclevels.get(i).getLevel());
			}
			return levels;
		}
		return levels;

	}// 查所有等级

	@Override
	public List<String> queryEmpIdByLevel(Integer level) {
		OpDoclevelExample example = new OpDoclevelExample();
		com.wnxy.hospital.mims.entity.OpDoclevelExample.Criteria criteria = example.createCriteria();
		criteria.andLevelEqualTo(level);
		List<OpDoclevel> opDoclevels = opDoclevelMapper.selectByExample(example);
		List<String> empIds = new ArrayList<String>();
		if (opDoclevels.size() != 0) {
			for (int i = 0; i < opDoclevels.size(); i++) {
				empIds.add(i, opDoclevels.get(i).getEmpId());
			}
			return empIds;
		}
		return empIds;
	}// 查询指定等级下的员工编号

	@Override
	public List<OpDoclevel> queryOpDoclevelByEmpId(String empId) {
		OpDoclevelExample example = new OpDoclevelExample();
		com.wnxy.hospital.mims.entity.OpDoclevelExample.Criteria criteria = example.createCriteria();
		criteria.andEmpIdEqualTo(empId);
		System.out.println("根据员工编号查出来的收费信息：" + opDoclevelMapper.selectByExample(example));
		return opDoclevelMapper.selectByExample(example);

	}// 查询指定员工编号对应的收费情况

	@Override
	public void updateOpDoclevelByDlId(OpDoclevel opDoclevel) {
		opDoclevelMapper.updateByPrimaryKey(opDoclevel);
	}// 根据收费等级编号修改等级表

	@Override
	public void delOpDoclevelByDlId(String dlId) {
		opDoclevelMapper.deleteByPrimaryKey(dlId);
	}// 根据收费等级编号删除等级记录

}
