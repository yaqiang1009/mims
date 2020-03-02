package com.wnxy.hospital.mims.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wnxy.hospital.mims.entity.IpHospitalized;
import com.wnxy.hospital.mims.service.impl.Ip_HosOrderServiceImpl;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
//处理器
@Slf4j
@Controller
public class IpController {
	@Resource
	@Setter private ApplicationContext ac;
	
	@RequestMapping("/ip_hosporder")
	public String mycont1(Model model,HttpServletRequest request) {
		Ip_HosOrderServiceImpl ip_HosOrderServiceImpl =(Ip_HosOrderServiceImpl) ac.getBean("ip_HosOrderServiceImpl");
		List<IpHospitalized> ipHospitalizeds = ip_HosOrderServiceImpl.selectAllHos();
		model.addAttribute("ipHospitalizeds",ipHospitalizeds);
		return "ip_hosporder";
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
