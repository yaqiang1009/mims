package com.wnxy.hospital.mims.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.Office;
import com.wnxy.hospital.mims.entity.OpDep;
import com.wnxy.hospital.mims.entity.Role;
import com.wnxy.hospital.mims.entity.UserPsd;
import com.wnxy.hospital.mims.service.Sys_UserService;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
//处理器
@Slf4j
@Controller
public class MyController {
	@Resource
	@Setter private ApplicationContext ac;
	//登录请求
	@RequestMapping("/loginsubmit")
	public String mycont1(String user,String password,Model model,HttpServletRequest request) {
		System.out.println(user);
		System.out.println(password);
		return "/index/index.html";
	}
	//用户管理
	@RequestMapping("/sys_user_control/{index}")
	public String syUserControl(String name,@PathVariable("index") int index,Model model,HttpServletRequest request) {
		Sys_UserService userService = (Sys_UserService)ac.getBean("sys_UserServiceImpl");
		PageInfo<UserPsd> userp = userService.selectUser(name, index);
		model.addAttribute("userp", userp);
		model.addAttribute("name",name);
		return "sys_user_control";
	}
	//用户详情
	@RequestMapping("/sys_user_details/{userId}")
	public String sysUserDetails(@PathVariable("userId") String userId,Model model,HttpServletRequest request) {
		//查询用户信息
		Sys_UserService userService = (Sys_UserService)ac.getBean("sys_UserServiceImpl");
		UserPsd user = userService.selUserDet(userId);
		model.addAttribute("user", user);
		return "sys_user_details";
	}
	//新增用户检索信息
	@RequestMapping("/sys_insert_user")
	public String sysInsertUser(Model model,HttpServletRequest request) {
		//检索 角色 科室 院部
		Sys_UserService userService = (Sys_UserService)ac.getBean("sys_UserServiceImpl");
		List<OpDep> opDeps = userService.selectDep();
		List<Office> offices = userService.selectOffice();
		List<Role> roles = userService.selectRole();
		model.addAttribute("opDeps", opDeps);
		model.addAttribute("offices", offices);
		model.addAttribute("roles", roles);
		return "/sys_insert_user";
	}
	//新增用户提交信息
	@RequestMapping("/sys_insert_sub")
	public String sysInsertSub(UserPsd userPsd,MultipartFile img,Model model,HttpServletRequest request) {
		String[] roleIds = request.getParameterValues("roleIds");	
		Sys_UserService userService = (Sys_UserService)ac.getBean("sys_UserServiceImpl");
		String uuidUser = userService.insertUser(userPsd, img, roleIds, request);
		return "redirect:/sys_user_details/"+uuidUser;
	}
	/*同步请求模板
	@RequestMapping("/mycont1")
	public String mycont1(Model model,HttpServletRequest request) {
		
		return "aaa";
	}
	*/
	
	/*异步请求模板
	@ResponseBody
	@RequestMapping("/mycont1")
	public String mycont1(HttpServletRequest request) {
		
		return "aaa";
	}
	*/
	
}
