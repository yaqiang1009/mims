package com.wnxy.hospital.mims.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.Office;
import com.wnxy.hospital.mims.entity.OpDep;
import com.wnxy.hospital.mims.entity.Role;
import com.wnxy.hospital.mims.entity.UserPsd;

public interface Sys_UserService {
	PageInfo<UserPsd> selectUser(String name,int index);
	UserPsd selUserDet(String userId);
	List<OpDep> selectDep();
	List<Office> selectOffice();
	List<Role> selectRole();
	String insertUser(UserPsd userPsd,MultipartFile img,String[] roleIds,HttpServletRequest request);
}
