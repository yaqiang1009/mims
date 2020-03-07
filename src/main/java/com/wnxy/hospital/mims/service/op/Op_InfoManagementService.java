package com.wnxy.hospital.mims.service.op;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.Office;
import com.wnxy.hospital.mims.entity.OpDep;
import com.wnxy.hospital.mims.entity.OpDoclevel;

public interface Op_InfoManagementService {
	// Emp员工表操作
	public void addEmp(Emp emp);// 添加员工信息

	public List<Emp> queryAllEmp();// 查询所有员工

	public Emp queryEmpByEmpId(String empId);// 根据员工编号查询指定员工

	public List<Emp> queryEmpByDepId(String depId);// 查询指定科室编号的员工，没加分页
	//public PageInfo<Emp> queryEmpByDepId(String depId, int index);// 查询指定科室编号的员工，加分页

	public List<Emp> queryEmpByEmpIdentity(String empIdentity);// 查询指定身份证的员工

	public List<Emp> queryEmpByOfficeId(String officeId);// 查询指定部门officeId下的员工

	public void delEmpByEmpId(String empId);// 根据empdId删除指定员工

	public void updateEmpByEmpId(Emp emp);// 根据empId修改指定员工信息

	// OpDep门诊科室表操作
	public void addOpDep(String depName);// 添加科室信息

	public List<OpDep> queryAllOpDep();// 查询所有门诊科室

	public OpDep queryOpDepByDepId(String depId);// 根据科室编号查询指定科室

	public List<OpDep> queryOpDepByDepName(String depName);// 根据科室名称查询科室

	public void delOpDepByDepId(String depId);// 根据depId删除指定科室

	public void updateOpDepByDepId(OpDep opDep);// 根据depId修改指定科室信息

	// Office表操作
	public void addOffice(String officeName);// 添加部门信息

	public List<Office> queryAllOffice();// 查询所有部门

	public Office queryOfficeByOfficeId(String officeId);// 根据部门编号查询指定部门

	public List<Office> queryOfficeByOfficeName(String officeName);// 根据部门名称查询部门

	public void delOfficeByOfficeId(String officeId);// 根据OfficeId删除指定部门

	public void updateOfficeByOfficeId(Office office);// 根据officeId修改指定部门信息

	// 医生挂号费等级表OpDoclevel操作
	public void addOpDoclevel(OpDoclevel opDoclevel);// 添加挂号费等级信息

	public List<OpDoclevel> queryAllOpDoclevel();// 查询所有挂号费等级信息

	public List<Integer> queryAllLevel();// 查所有等级

	public List<String> queryEmpIdByLevel(Integer level);// 查询指定等级下的员工编号

	public List<OpDoclevel> queryOpDoclevelByEmpId(String empId);// 查询指定员工编号对应的收费情况

	public void updateOpDoclevelByDlId(OpDoclevel opDoclevel);// 根据收费等级编号修改等级表

	public void delOpDoclevelByDlId(String dlId);// 根据收费等级编号删除等级记录

}
