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

import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.IpBed;
import com.wnxy.hospital.mims.entity.IpHospitalized;
import com.wnxy.hospital.mims.entity.IpLeaveapply;
import com.wnxy.hospital.mims.entity.IpRemedy;
import com.wnxy.hospital.mims.entity.IpWard;
import com.wnxy.hospital.mims.mapper.IpBedMapper;
import com.wnxy.hospital.mims.service.Ip_HosOrderService;
import com.wnxy.hospital.mims.service.Ip_RemedyService;
import com.wnxy.hospital.mims.service.Ip_bedService;
import com.wnxy.hospital.mims.service.Ip_empService;
import com.wnxy.hospital.mims.service.Ip_wardService;
import com.wnxy.hospital.mims.service.Ip_LeaveHospService;
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
	public String ip_HospOrder(Model model,HttpServletRequest request) {
		Ip_HosOrderService ip_HosOrderService =(Ip_HosOrderService) ac.getBean("ip_HosOrderServiceImpl");
		List<IpHospitalized> ipHospitalizeds = ip_HosOrderService.selectAllHos();
		model.addAttribute("ipHospitalizeds",ipHospitalizeds);
		return "ip_hosporder";
	}
	//检索指定住院订单
	@RequestMapping("/Hos/reject/{id}")
	public String hos_Reject(@PathVariable("id") String id,Model model) {
		Ip_HosOrderService ip_HosOrderService =(Ip_HosOrderService) ac.getBean("ip_HosOrderServiceImpl");
		//查询
		IpHospitalized ipHospitalized = ip_HosOrderService.selectHos(id);
		//赋值
		model.addAttribute("ipHospitalized",ipHospitalized);
		return "ip_hosporder_reject";
	}
	//住院订单拒绝入住
	@RequestMapping("/Hos_reject_sub")
	public String hos_Reject_Sub(String id,String remarks,Model model) {
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
	//检索医疗单所需信息
	@RequestMapping("/Hos/pass/{id}")
	public String hos_Pass(@PathVariable("id") String id,Model model) {
		Ip_HosOrderService ip_HosOrderService =(Ip_HosOrderService) ac.getBean("ip_HosOrderServiceImpl");
		//查询
		IpHospitalized ipHospitalized = ip_HosOrderService.selectHos(id);
		//住院订单对象赋值
		model.addAttribute("ipHospitalized",ipHospitalized);
		//检索所有医生
		Ip_empService ip_emp = (Ip_empService)ac.getBean("ip_empServiceImpl");
		List<Emp> emps = ip_emp.selectAllEmp();
		model.addAttribute("emps",emps);
		//检索所有病房
		Ip_wardService ip_ward =(Ip_wardService) ac.getBean("ip_wardServiceImpl");
		List<IpWard> wards = ip_ward.selectAllWard();
		model.addAttribute("wards",wards);
		return "ip_hosporder_pass";
	}
	//添加医疗单时异步请求科室信息
	@ResponseBody
	@RequestMapping("/emp_dep")
	public Object emp_Dep(String empid) {
		Ip_empService ip_emp = (Ip_empService)ac.getBean("ip_empServiceImpl");
		Emp emp = ip_emp.selectEmp(empid);
		return emp;
	}
	//添加医疗单时异步请求床位信息
	@ResponseBody
	@RequestMapping("/word_bed")
	public Object word_Bed(String wardId) {
		System.out.println(wardId);
		Ip_bedService ip_bedService =(Ip_bedService)ac.getBean("ip_bedServiceImpl");
		List<IpBed> beds = ip_bedService.selectBed(wardId); 
		return beds;
	}
	//入院,完成住院订单，添加医疗单
	@RequestMapping("/Hos_pass_sub")
	public String hos_Pass_Sub(String id,String empId,String wardId,String bedId,Model model) {
		Ip_HosOrderService ip_HosOrderService =(Ip_HosOrderService) ac.getBean("ip_HosOrderServiceImpl");
		//查询
		try {
			ip_HosOrderService.overOrder(id, empId, wardId, bedId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/ip_hosporder";
	}
	//************************出院审核
	//检索出院申请信息
	@RequestMapping("/leaveHospOrder")
	public String leaveHospOrder(Model model) {
		//获取对象，调方法
		Ip_LeaveHospService ieavehospService = (Ip_LeaveHospService)ac.getBean("ip_LeaveHospServiceImpl");
		List<IpLeaveapply> IpLeaveapplys = ieavehospService.selectAllLeave();
		model.addAttribute("IpLeaveapplys",IpLeaveapplys);
		return "ip_leavehosp";
	}
	//通过出院申请
	@RequestMapping("/leave/pass/{id}")
	public String leavePass(@PathVariable("id") String id) {
		//修改订单状态
		Ip_LeaveHospService ieavehospService = (Ip_LeaveHospService)ac.getBean("ip_LeaveHospServiceImpl");
		ieavehospService.leavePass(id);
		return "redirect:/leaveHospOrder";
	}
	//拒绝出院申请,检索信息
	@RequestMapping("/leave/reject/{id}")
	public String leaveReject(@PathVariable("id") String id,Model model) {
		//检索指定出院单
		Ip_LeaveHospService ieavehospService = (Ip_LeaveHospService)ac.getBean("ip_LeaveHospServiceImpl");
		IpLeaveapply leaveHosp = ieavehospService.selectLeave(id);
		model.addAttribute("leaveHosp", leaveHosp);
		return "ip_leavehosp_reject";
	}
	//拒绝出院申请,修改信息
	@RequestMapping("/leave_reject_sub")
	public String leaveRejectSub(String id,String remarks,Model model) {
		//检索指定出院单
		Ip_LeaveHospService ieavehospService = (Ip_LeaveHospService)ac.getBean("ip_LeaveHospServiceImpl");
		ieavehospService.leaveReject(id, remarks);
		return "redirect:/leaveHospOrder";
	}
	//*************************医疗单相关
	//住院中医疗单全部查询
	@RequestMapping("/ip_selectremedy")
	public String ip_SelectRemedy(Model model) {
		Ip_RemedyService remedy = (Ip_RemedyService)ac.getBean("ip_RemedyServiceImpl");
		List<IpRemedy> remedys = remedy.selectAllRemedy("");
		model.addAttribute("remedys", remedys);
		return "ip_remedy";
	}
	//修改指定医疗单,检索信息
	@RequestMapping("/remedy_alter/{id}")
	public String ip_AlterRemedy(@PathVariable("id") String id,Model model) {
		//检索医疗单信息
		Ip_RemedyService ip_RemedyService = (Ip_RemedyService)ac.getBean("ip_RemedyServiceImpl");
		IpRemedy remedy = ip_RemedyService.selectRemedy(id);
		model.addAttribute("remedy", remedy);
		//检索所有医生
		Ip_empService ip_emp = (Ip_empService)ac.getBean("ip_empServiceImpl");
		List<Emp> emps = ip_emp.selectAllEmp();
		model.addAttribute("emps",emps);
		//检索所有病房
		Ip_wardService ip_ward =(Ip_wardService) ac.getBean("ip_wardServiceImpl");
		List<IpWard> wards = ip_ward.selectAllWard();
		model.addAttribute("wards",wards);
		//检索当前病房空余床位
		Ip_bedService ip_bedService =(Ip_bedService) ac.getBean("ip_bedServiceImpl");
		List<IpBed> beds = ip_bedService.selectBed(remedy.getWardId());
		model.addAttribute("beds",beds);
		return "ip_remedy_alter";
	}
	//修改指定医疗单,修改信息
	@RequestMapping("/remedy_alter_sub")
	public String remedyAlterSub(String id,String bedId,String empId,String wardId,Model model) {
		//修改指定医疗单
		Ip_RemedyService ip_RemedyService = (Ip_RemedyService)ac.getBean("ip_RemedyServiceImpl");
		ip_RemedyService.alertRemedy(id, bedId, empId, wardId);	
		return "redirect:/ip_selectremedy";
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
