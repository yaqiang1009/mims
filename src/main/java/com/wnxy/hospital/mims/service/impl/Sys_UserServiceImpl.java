package com.wnxy.hospital.mims.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.EmpExample;
import com.wnxy.hospital.mims.entity.EmpRole;
import com.wnxy.hospital.mims.entity.EmpRoleExample;
import com.wnxy.hospital.mims.entity.Office;
import com.wnxy.hospital.mims.entity.OfficeExample;
import com.wnxy.hospital.mims.entity.OpDep;
import com.wnxy.hospital.mims.entity.OpDepExample;
import com.wnxy.hospital.mims.entity.Role;
import com.wnxy.hospital.mims.entity.RoleExample;
import com.wnxy.hospital.mims.entity.UserPsd;
import com.wnxy.hospital.mims.entity.UserPsdExample;
import com.wnxy.hospital.mims.mapper.EmpMapper;
import com.wnxy.hospital.mims.mapper.EmpRoleMapper;
import com.wnxy.hospital.mims.mapper.OfficeMapper;
import com.wnxy.hospital.mims.mapper.OpDepMapper;
import com.wnxy.hospital.mims.mapper.RoleMapper;
import com.wnxy.hospital.mims.mapper.UserPsdMapper;
import com.wnxy.hospital.mims.service.Sys_UserService;
@Component
public class Sys_UserServiceImpl implements Sys_UserService {
	@Autowired
	private UserPsdMapper userPsdMapper;
	@Autowired
	private EmpMapper empMapper;
	@Autowired
	private OfficeMapper officeMapper;
	@Autowired
	private OpDepMapper opDepMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private EmpRoleMapper empRoleMapper;
	//查询所有用户
	@Override
	public PageInfo<UserPsd> selectUser(String name,int index) {
		//判断是否模糊搜索
		UserPsdExample example=new UserPsdExample();
		if(!"".equals(name)) {
			EmpExample exampleEmp=new EmpExample();
			exampleEmp.createCriteria().andEmpNameLike("%"+name+"%");
			List<Emp> emps = empMapper.selectByExample(exampleEmp);
			List<String> values=new ArrayList<String>();
			values.add("");
			//获取id集合
			for(Emp emp:emps) {
				values.add(emp.getEmpId());
			}
			//只检索集合中用户
			example.createCriteria().andEmpIdIn(values);
		}
		//查询用户
		PageHelper.startPage(index, 10);
		List<UserPsd> users = userPsdMapper.selectByExample(example);
		//对象赋值
		for(UserPsd user:users) {
			//emp赋值
			Emp emp = empMapper.selectByPrimaryKey(user.getEmpId());
			user.setEmp(emp);
			//院部赋值
			Office office = officeMapper.selectByPrimaryKey(emp.getOfficeId());
			emp.setOffice(office);
			//科室赋值
			OpDep opDep = opDepMapper.selectByPrimaryKey(emp.getDepId());
			emp.setOpDep(opDep);
			
		}
		PageInfo<UserPsd>userp=new PageInfo<UserPsd>(users);
		return userp;
	}
	//查询指定用户
	@Override
	public UserPsd selUserDet(String userId) {
		UserPsd user = userPsdMapper.selectByPrimaryKey(userId);
		//对象赋值
			Emp emp = empMapper.selectByPrimaryKey(user.getEmpId());
			user.setEmp(emp);
			//院部赋值
			Office office = officeMapper.selectByPrimaryKey(emp.getOfficeId());
			emp.setOffice(office);
			//科室赋值
			OpDep opDep = opDepMapper.selectByPrimaryKey(emp.getDepId());
			emp.setOpDep(opDep);
			//角色赋值
			EmpRoleExample exampleER=new EmpRoleExample();
			exampleER.createCriteria().andEmpIdEqualTo(emp.getEmpId());
			List<EmpRole> EmpRoles = empRoleMapper.selectByExample(exampleER);
			List<String> values=new ArrayList<String>();
			values.add("");
			for(EmpRole empRole:EmpRoles) {
				values.add(empRole.getRolId());
			}
			RoleExample example=new RoleExample();
			example.createCriteria().andRolIdIn(values);
			List<Role> roles = roleMapper.selectByExample(example);
			user.setRoles(roles);
		return user;
	}
	//查询科室
	@Override
	public List<OpDep> selectDep() {
		OpDepExample example=new OpDepExample();
		List<OpDep> opDeps = opDepMapper.selectByExample(example);
		return opDeps;
	}
	//查询院部
	@Override
	public List<Office> selectOffice() {
		OfficeExample example=new OfficeExample();
		List<Office> offices = officeMapper.selectByExample(example);
		return offices;
	}
	//查询角色
	@Override
	public List<Role> selectRole() {
		RoleExample example=new RoleExample();
		List<Role> roles = roleMapper.selectByExample(example);
		return roles;
	}
	//插入新用户
	@Transactional
	@Override
	public String insertUser(UserPsd userPsd,MultipartFile img, String[] roleIds,HttpServletRequest request) {
		try {
			//图片处理
			//项目路径
			//String path = request.getServletContext().getRealPath("/img/empphoto");
			//映射路径
			String path = "D:/img/empphoto";
			//文件名
			String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
			String fileName;
			if(img.getOriginalFilename().equals("")) {
				//用户未上传，默认头像
				fileName="10.jpg";
			}else {
				fileName=uuid+img.getOriginalFilename();
				//创建文件
				File file=new File(path, fileName);
				//保存
				img.transferTo(file);
			}
			//创建emp
			Emp emp=userPsd.getEmp();
			String uuidEmp = UUID.randomUUID().toString().trim().replaceAll("-", "");
			emp.setEmpId(uuidEmp);
			emp.setEmpHireday(new Date());
			emp.setEmpPhoto("/img/empphoto/"+fileName);
			//emp.setEmpPhoto(empPhoto);
			empMapper.insert(emp);
			//创建user
			String uuidUser = UUID.randomUUID().toString().trim().replaceAll("-", "");
			userPsd.setUserId(uuidUser);
			userPsd.setEmpId(uuidEmp);
			//密码加密
			String passward= new SimpleHash("MD5","123456","m",2).toString();
			userPsd.setUserPassword(passward);
			userPsdMapper.insert(userPsd);
			//创建角色用户表
			if(roleIds!=null) {
				for(String roleId:roleIds) {
					String uuidER = UUID.randomUUID().toString().trim().replaceAll("-", "");
					EmpRole empRole=new EmpRole(uuidER, roleId, uuidEmp);
					empRoleMapper.insert(empRole);
				}
			}
			return uuidUser;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//修改密码
	@Override
	public void alterPwd(String user, String pwd) {
		//获取当前用户
		UserPsdExample example=new UserPsdExample();
		example.createCriteria().andUserAccountEqualTo(user);
		List<UserPsd> users = userPsdMapper.selectByExample(example);
		UserPsd use=users.get(0);
		//密码加密
		pwd= new SimpleHash("MD5",pwd,"m",2).toString();
		//修改密码
		use.setUserPassword(pwd);
		try {
			userPsdMapper.updateByPrimaryKey(use);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//修改用户信息
		@Transactional
		@Override
		public String alertUser(UserPsd userPsd,MultipartFile img, String[] roleIds) {
			try {
				//查询用户原始信息
				Emp newEmp = empMapper.selectByPrimaryKey(userPsd.getEmpId());
				Emp emp=userPsd.getEmp();
				//图片处理
				if(!img.getOriginalFilename().equals("")) {
					//用户更新照片
					String path = "D:/img/empphoto";
					//文件名
					String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
					String fileName=uuid+img.getOriginalFilename();
					//创建文件
					File file=new File(path, fileName);
					//保存
					img.transferTo(file);
					newEmp.setEmpPhoto("/img/empphoto/"+fileName);
				}
				//更新emp
				newEmp.setEmpPhone(emp.getEmpPhone());
				newEmp.setEmpEmail(emp.getEmpEmail());
				newEmp.setOfficeId(emp.getOfficeId());
				newEmp.setDepId(emp.getDepId());
				newEmp.setEmpAddress(emp.getEmpAddress());
				empMapper.updateByPrimaryKey(newEmp);
				//更新user
				UserPsd newUser = userPsdMapper.selectByPrimaryKey(userPsd.getUserId());
				newUser.setUserAccount(userPsd.getUserAccount());
				userPsdMapper.updateByPrimaryKey(newUser);
				//更新角色用户表
				//删除原有角色
				EmpRoleExample exampleDel= new EmpRoleExample();
				exampleDel.createCriteria().andEmpIdEqualTo(newEmp.getEmpId());
				empRoleMapper.deleteByExample(exampleDel);
				//添加新角色
				if(roleIds!=null) {
					for(String roleId:roleIds) {
						String uuidER = UUID.randomUUID().toString().trim().replaceAll("-", "");
						EmpRole empRole=new EmpRole(uuidER, roleId, newEmp.getEmpId());
						empRoleMapper.insert(empRole);
					}
				}
				return newUser.getUserId();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
}
