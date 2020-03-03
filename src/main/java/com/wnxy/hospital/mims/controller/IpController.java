package com.wnxy.hospital.mims.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wnxy.hospital.mims.entity.IpHospitalized;
import com.wnxy.hospital.mims.service.Ip_HosOrderService;
import com.wnxy.hospital.mims.service.impl.Ip_HosOrderServiceImpl;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
//处理器
@Slf4j
@Controller
public class IpController {
	@Resource
	@Setter private ApplicationContext ac;
	//检索全部住院订单
	@RequestMapping("/ip_hosporder")
	public String ip_hosporder(Model model,HttpServletRequest request) {
		Ip_HosOrderService ip_HosOrderService =(Ip_HosOrderService) ac.getBean("ip_HosOrderServiceImpl");
		List<IpHospitalized> ipHospitalizeds = ip_HosOrderService.selectAllHos();
		model.addAttribute("ipHospitalizeds",ipHospitalizeds);
		return "ip_hosporder";
	}
	//检索指定住院订单
	@RequestMapping("/Hos/reject/{id}")
	public String Hos_reject(@PathVariable("id") String id,Model model) {
		Ip_HosOrderService ip_HosOrderService =(Ip_HosOrderService) ac.getBean("ip_HosOrderServiceImpl");
		//查询
		IpHospitalized ipHospitalized = ip_HosOrderService.selectHos(id);
		//赋值
		model.addAttribute("ipHospitalized",ipHospitalized);
		return "ip_hosporder_reject";
	}
	//住院订单拒绝入住
	@RequestMapping("/Hos_reject_sub")
	public String Hos_reject_sub(String id,String remarks,Model model) {
		Ip_HosOrderService ip_HosOrderService =(Ip_HosOrderService) ac.getBean("ip_HosOrderServiceImpl");
		//查询
		IpHospitalized ipHospitalized = ip_HosOrderService.selectHos(id);
		//修改信息
		ipHospitalized.setRemarks(remarks);
		ipHospitalized.setHosOrder("拒绝入院");
		//更新数据库
		try {
			ip_HosOrderService.updata(ipHospitalized);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/ip_hosporder";
	}
	//检索指
	@RequestMapping("/Hos/pass/{id}")
	public String Hos_pass(@PathVariable("id") String id,Model model) {
		Ip_HosOrderService ip_HosOrderService =(Ip_HosOrderService) ac.getBean("ip_HosOrderServiceImpl");
		//查询
		IpHospitalized ipHospitalized = ip_HosOrderService.selectHos(id);
		//赋值
		model.addAttribute("ipHospitalized",ipHospitalized);
		return "ip_hosporder_reject";
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
