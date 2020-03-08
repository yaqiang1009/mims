package com.wnxy.hospital.mims.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.ApplicationContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.Office;
import com.wnxy.hospital.mims.entity.OpDoclevel;
import com.wnxy.hospital.mims.service.op.Op_InfoManagementService;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class OpInfoController {
	@Resource
	@Setter
	private ApplicationContext ac;

	// 添加新部门
	@RequestMapping("/op_newOffice")
	public String op_newOffice(String officeName, HttpSession session, Model model) {
		Op_InfoManagementService op_InfoManagementService = (Op_InfoManagementService) ac
				.getBean("op_InfoManagementServiceImpl");
		try {
			op_InfoManagementService.addOffice(officeName);
			session.invalidate();// 添加成功后清空session
			model.addAttribute("msg", "部门添加成功");
			return "op_msg";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "op_msg";
		}
	}

	// 添加新科室
	@RequestMapping("/op_newDep")
	public String op_newDep(String depName, HttpSession session, Model model) {
		Op_InfoManagementService op_InfoManagementService = (Op_InfoManagementService) ac
				.getBean("op_InfoManagementServiceImpl");
		try {
			op_InfoManagementService.addOpDep(depName);
			session.invalidate();// 添加成功后清空session
			model.addAttribute("msg", "科室添加成功");
			return "op_msg";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "op_msg";
		}
	}

	// 添加新门诊挂号收费等级前将所有医生打到域里
	@RequestMapping("/op_newDocLevelPre")
	public String op_newDocLevel(Model model) {
		Op_InfoManagementService op_InfoManagementService = (Op_InfoManagementService) ac
				.getBean("op_InfoManagementServiceImpl");
		String docOfficeId = op_InfoManagementService.queryOfficeByOfficeName("门诊部").get(0).getOfficeId();// 查询门诊部的部门编号
		List<Emp> allEmp = op_InfoManagementService.queryAllEmp();
		List<Emp> emps = new ArrayList<Emp>();
		for (Emp emp : allEmp) {// 先查出所有门诊部的医生打到域中，方便下拉列表选人
			if (emp.getOfficeId().equals(docOfficeId)) {
				emps.add(emp);
			}
		}
		model.addAttribute("emps", emps);
		return "op_newDocLevel";

	}

	// 添加新门诊挂号收费等级
	@RequestMapping("/op_newDocLevel")
	public String op_newDocLevel(String empId, Integer level, String price, HttpSession session, Model model) {
		Op_InfoManagementService op_InfoManagementService = (Op_InfoManagementService) ac
				.getBean("op_InfoManagementServiceImpl");
		try {
			float priceFloat = Float.parseFloat(price);
			OpDoclevel opDoclevel = new OpDoclevel(null, empId, level, priceFloat);
			op_InfoManagementService.addOpDoclevel(opDoclevel);
			session.invalidate();// 添加成功后清空session
			model.addAttribute("msg", "收费等级添加成功");
			return "op_msg";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "op_msg";
		}
	}

}