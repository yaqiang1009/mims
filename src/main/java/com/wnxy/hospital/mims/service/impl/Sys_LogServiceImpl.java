package com.wnxy.hospital.mims.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wnxy.hospital.mims.entity.Authority;
import com.wnxy.hospital.mims.entity.EmpRole;
import com.wnxy.hospital.mims.entity.EmpRoleExample;
import com.wnxy.hospital.mims.entity.Role;
import com.wnxy.hospital.mims.entity.RoleExample;
import com.wnxy.hospital.mims.entity.UserAuthority;
import com.wnxy.hospital.mims.entity.UserAuthorityExample;
import com.wnxy.hospital.mims.entity.UserPsd;
import com.wnxy.hospital.mims.entity.UserPsdExample;
import com.wnxy.hospital.mims.exception.UserException;
import com.wnxy.hospital.mims.mapper.AuthorityMapper;
import com.wnxy.hospital.mims.mapper.EmpMapper;
import com.wnxy.hospital.mims.mapper.EmpRoleMapper;
import com.wnxy.hospital.mims.mapper.RoleMapper;
import com.wnxy.hospital.mims.mapper.UserAuthorityMapper;
import com.wnxy.hospital.mims.mapper.UserPsdMapper;
import com.wnxy.hospital.mims.service.Sys_LogService;
@Component
public class Sys_LogServiceImpl implements Sys_LogService {
	@Autowired
	private UserPsdMapper userPsdMapper;
	@Resource
	private UserAuthorityMapper userAuthorityMapper;
	@Resource
	private AuthorityMapper authorityMapper;
	@Resource
	private EmpRoleMapper empRoleMapper;
	@Resource
	private RoleMapper roleMapper;
	//查询用户是否存在
	public String selectUser(String user){
		//查询用户
		UserPsdExample example=new UserPsdExample();
		example.createCriteria().andUserAccountEqualTo(user);
		List<UserPsd> us = userPsdMapper.selectByExample(example);
		//判断结果
		if(us.size()==0) {
			throw new UserException("用户不存在");
		}
		return us.get(0).getUserPassword();
	}
	//查询角色信息
	@Override
	public Collection<String> selectAuth(String user) {
		//获取empid
		UserPsdExample exampleUser=new UserPsdExample();
		exampleUser.createCriteria().andUserAccountEqualTo(user);
		List<UserPsd> userPsd = userPsdMapper.selectByExample(exampleUser);
		String empId=userPsd.get(0).getEmpId();
		Collection<String> authoritys=new ArrayList<String>();
		//获取角色
		EmpRoleExample exampleER=new EmpRoleExample();
		exampleER.createCriteria().andEmpIdEqualTo(empId);
		List<EmpRole> EmpRoles = empRoleMapper.selectByExample(exampleER);
		for(EmpRole empRole:EmpRoles) {
			//获取权限
			UserAuthorityExample exampleAuth=new UserAuthorityExample();
			exampleAuth.createCriteria().andRolIdEqualTo(empRole.getRolId());
			List<UserAuthority> userAuthoritys = userAuthorityMapper.selectByExample(exampleAuth);
			//赋值
			for(UserAuthority userAuthority:userAuthoritys) {
				Authority authority = authorityMapper.selectByPrimaryKey(userAuthority.getAuthorityId());
				authoritys.add(authority.getAuthorityName());
			}
		}
		return authoritys;
	}
}
