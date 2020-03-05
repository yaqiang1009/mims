package com.wnxy.hospital.mims.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.OpDep;
import com.wnxy.hospital.mims.entity.OpDoclevel;
import com.wnxy.hospital.mims.entity.OpRegistry;
import com.wnxy.hospital.mims.service.op.Op_InfoManagementService;
import com.wnxy.hospital.mims.service.op.impl.Op_RegistryServiceImpl;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class OpRegController {
	@Resource
	@Setter
	private ApplicationContext ac;

	// 将就诊卡号存到session中
	@RequestMapping("/op_cardIdTosession")
	public String op_cardIdTosession(HttpServletRequest req) {
		String cardId = req.getParameter("cardId");
		req.getSession().setAttribute("cardId", cardId);
		return "forward:/op_showAllDep";
	}

	// 查全部科室
	@RequestMapping("/op_showAllDep")
	public String op_showAllDep(Model model, HttpServletRequest request) {
		Op_InfoManagementService op_InfoManagementService = (Op_InfoManagementService) ac
				.getBean("op_InfoManagementServiceImpl");
		List<OpDep> opDeps = op_InfoManagementService.queryAllOpDep();
		model.addAttribute("opDeps", opDeps);
		return "op_showAllDep";
	}

	// 查科室编号对应的全部医生
	@RequestMapping("/op_showDocInDep/{depId}")
	public String op_showDocInDep(@PathVariable("depId") String depId, Model model) {
		Op_InfoManagementService op_InfoManagementService = (Op_InfoManagementService) ac
				.getBean("op_InfoManagementServiceImpl");
		List<Emp> emps = op_InfoManagementService.queryEmpByDepId(depId);// 根据页面传过来的部门编号查对应部门的医生
		model.addAttribute("emps", emps);
		return "op_showDocInDep";
	}

	// 查对应员工编号的医生详细信息
	@RequestMapping("/op_showDocDetail/{empId}")
	public String op_showDocDetail(@PathVariable("empId") String empId, Model model) {
		Op_InfoManagementService op_InfoManagementService = (Op_InfoManagementService) ac
				.getBean("op_InfoManagementServiceImpl");
		Emp emp = op_InfoManagementService.queryEmpByEmpId(empId);// 根据页面传过来的部门编号查对应部门的医生
		List<OpDoclevel> opDoclevels = op_InfoManagementService.queryOpDoclevelByEmpId(empId);// 根据医生编号查医生对应的级别和收费信息
		OpDoclevel opDoclevel = opDoclevels.get(0);// 实际只会返回一条收费等级记录
		model.addAttribute("emp", emp);// 把员工信息存到域里
		model.addAttribute("opDoclevel", opDoclevel);// 把收费等级信息存到域里
		return "op_showDocDetail";
	}

	// 调用挂号方法
	@RequestMapping("op_registry/{empId}")
	public String op_registry(@PathVariable("empId") String empId, HttpServletRequest req, HttpSession session,
			Model model) {

		Op_RegistryServiceImpl op_RegistryServiceImpl = (Op_RegistryServiceImpl) ac.getBean("op_RegistryServiceImpl");
		String cardId = (String) req.getSession().getAttribute("cardId");// 从session中获取就诊卡号
		OpRegistry opRegistry = op_RegistryServiceImpl.newOpRegistry(empId, cardId);
		if (opRegistry == null) {
			session.invalidate();// 当前挂号完成后清空session
			model.addAttribute("msg", "挂号失败");
			return "op_msg";
		} else {
			session.invalidate();// 当前挂号完成后清空session
			model.addAttribute("msg", "挂号成功");
			return "op_msg";

		}

	}
}