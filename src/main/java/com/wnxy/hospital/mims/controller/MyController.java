package com.wnxy.hospital.mims.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
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
import com.wnxy.hospital.mims.service.Sys_LogService;
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
		
		//获取当前用户
		Subject subject = SecurityUtils.getSubject();
		//获取用户输入信息
		UsernamePasswordToken token=new UsernamePasswordToken(user,password);
		//匹配验证
		try {
			//securityManager.login(subject, token);
			subject.login(token);
			System.out.println("登录成功");
			return "redirect:/";
		} catch (IncorrectCredentialsException e) {
			model.addAttribute("mes", "2");
			System.out.println("密码错误");
		} catch (UnknownAccountException e) {
			model.addAttribute("mes", "1");
			System.out.println("用户不存在");
		}catch (AuthenticationException e) {
			e.printStackTrace();
		}
		model.addAttribute("user", user);
		return "/backstage/login.html";
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
	//修改用户检索信息
	@RequestMapping("/sys_alert_user/{userId}")
	public String sysAlertUser(@PathVariable("userId") String userId,Model model) {
		//检索 角色 科室 院部
		Sys_UserService userService = (Sys_UserService)ac.getBean("sys_UserServiceImpl");
		List<OpDep> opDeps = userService.selectDep();
		List<Office> offices = userService.selectOffice();
		List<Role> roles = userService.selectRole();
		model.addAttribute("opDeps", opDeps);
		model.addAttribute("offices", offices);
		model.addAttribute("roles", roles);
		//检索用户信息
		UserPsd userPsd = userService.selUserDet(userId);
		model.addAttribute("userPsd", userPsd);
		return "sys_alert_user";
	}
	//修改用户提交信息
	@RequestMapping("/sys_alert_user_sub")
	public String sysAlertUserSub(UserPsd userPsd,MultipartFile img,Model model,HttpServletRequest request) {
		String[] roleIds = request.getParameterValues("roleIds");	
		System.out.println("ro"+roleIds);
		Sys_UserService userService = (Sys_UserService)ac.getBean("sys_UserServiceImpl");
		String uuidUser = userService.alertUser(userPsd, img, roleIds);
		return "redirect:/sys_user_details/"+uuidUser;
	}
	//异步请求检查用户名是否存在
		@ResponseBody
		@RequestMapping("/check_user")
		public String checkUser(String user,HttpServletRequest request) {
			Sys_LogService sys_LogService = (Sys_LogService)ac.getBean("sys_LogServiceImpl");
			try {
				sys_LogService.selectUser(user);
				//用户存在
				return "1";
			} catch (Exception e) {
				//用户不存在
				e.printStackTrace();
				return "0";
			}
		}
		//修改用户信息异步请求检查用户名是否存在（不包括自身）
		@ResponseBody
		@RequestMapping("/alcheck_user")
		public String alCheckUser(String user,HttpServletRequest request) {
			Sys_LogService sys_LogService = (Sys_LogService)ac.getBean("sys_LogServiceImpl");
			try {
				sys_LogService.selectUser(user);
				//用户存在
				return "1";
			} catch (Exception e) {
				//用户不存在
				e.printStackTrace();
				return "0";
			}
		}
		//修改密码
		@ResponseBody
		@RequestMapping("/alter_pwd")
		public String alterPwd(String oldpwd,String newpwd,Model model,HttpServletRequest request) {
			Sys_LogService sys_LogService = (Sys_LogService)ac.getBean("sys_LogServiceImpl");
			Sys_UserService sys_UserService = (Sys_UserService)ac.getBean("sys_UserServiceImpl");
			try {
				//获取当前用户数据库密码
				Subject subject = SecurityUtils.getSubject();
				String pwd = sys_LogService.selectUser(subject.getPrincipal().toString());
				//密码加密判断
				oldpwd= new SimpleHash("MD5",oldpwd,"m",2).toString();
				if(pwd.equals(oldpwd)) {
					//密码相同，修改密码
					sys_UserService.alterPwd(subject.getPrincipal().toString(), newpwd);
					return "1";
				}else {
					//密码不同
					return "0";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
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
