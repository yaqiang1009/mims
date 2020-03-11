package com.wnxy.hospital.mims.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.OpDep;
import com.wnxy.hospital.mims.entity.OpDoclevel;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.entity.OpRegistry;
import com.wnxy.hospital.mims.service.op.Op_InfoManagementService;
import com.wnxy.hospital.mims.service.op.Op_RegistryService;
import com.wnxy.hospital.mims.service.op.impl.Op_RegistryServiceImpl;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class OpRegController {
	@Resource
	@Setter
	private ApplicationContext ac;

	// 录入病人基本信息并发卡
	@RequestMapping("/op_newCard")
	public String op_newCard(OpPatientinfo opPatientinfo, HttpSession session, Model model) {
		Op_RegistryService op_RegistryService = (Op_RegistryService) ac.getBean("op_RegistryServiceImpl");
		try {
			op_RegistryService.cardIssuingForPage(opPatientinfo);// 此处要用专门给页面用的带事务的二合一方法
			//session.invalidate();// 办卡完成后清空session
			model.addAttribute("msg", "办卡成功");
			return "op_msg";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "op_msg";
		}

	}

	// 将就诊卡号存到session中
	@RequestMapping("/op_cardIdTosession")
	public String op_cardIdTosession(HttpServletRequest req) {
		String cardId = req.getParameter("cardId");
		req.getSession().setAttribute("cardId", cardId);
		return "forward:/op_showAllDep";
	}

	// 挂失就诊卡
	@RequestMapping("/op_rebondCard")
	public String op_rebondCard(HttpServletRequest req, Model model) {
		Op_RegistryService op_RegistryService = (Op_RegistryService) ac.getBean("op_RegistryServiceImpl");
		String ptId = req.getParameter("ptId");
		try {
			op_RegistryService.cardRebondForPage(ptId);
			model.addAttribute("msg", "就诊卡挂失成功");
			return "op_msg";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "op_msg";
		}
	}

	// 查全部有效挂号单
	@RequestMapping("/op_allAvailableReg")
	public String op_allAvailableReg(HttpServletRequest req, Model model) {
		Op_RegistryService op_RegistryService = (Op_RegistryService) ac.getBean("op_RegistryServiceImpl");
		List<OpRegistry> availableOpRegistrys = op_RegistryService.AllAvailableOpRegistry(0);
		model.addAttribute("availableOpRegistrys", availableOpRegistrys);
		return ("op_allAvailableReg");
	}

	// 根据条件查挂号单
	@RequestMapping("/selectOpRegistryByCondition")
	public String selectOpRegistryByCondition(OpRegistry opRegistry, Model model) {
		Op_RegistryService op_RegistryService = (Op_RegistryService) ac.getBean("op_RegistryServiceImpl");
		float regprice = 0.0f;
		System.out.println("输入身份证：" + opRegistry.getPtId());
		System.out.println("输入日期：" + opRegistry.getDate());
		System.out.println("输入价格：" + opRegistry.getRegprice());
		if (opRegistry.getRegprice() == null) {
			opRegistry.setRegprice(regprice);
		}

		List<OpRegistry> opRegistrys = op_RegistryService.selectOpRegistryByCondition(opRegistry.getRsId(),
				opRegistry.getPtId(), opRegistry.getDlId(), opRegistry.getState(), opRegistry.getDate(),
				opRegistry.getRegprice(), opRegistry.getEmpId());
		model.addAttribute("opRegistrys", opRegistrys);
		return ("op_selectOpRegistryByCondition");
	}

	// 查全部门诊科室
	@RequestMapping("/op_showAllDep")
	public String op_showAllDep(Model model, HttpServletRequest request) {
		Op_InfoManagementService op_InfoManagementService = (Op_InfoManagementService) ac
				.getBean("op_InfoManagementServiceImpl");
		List<OpDep> AllOpDep = op_InfoManagementService.queryAllOpDep();
		List<OpDep> opDeps = new ArrayList<OpDep>();
		for (int i = 0; i < AllOpDep.size(); i++) {
			if (AllOpDep.get(i).getDepName().contains("门诊")) {// 剔除非医疗科室
				opDeps.add(AllOpDep.get(i));
			}

		}
		model.addAttribute("opDeps", opDeps);
		return "op_showAllDep";
	}

//	// 查科室编号对应的全部医生,未加分页
//	@RequestMapping("/op_showDocInDep/{depId}")
//	public String op_showDocInDep(@PathVariable("depId") String depId, Model model) {
//		Op_InfoManagementService op_InfoManagementService = (Op_InfoManagementService) ac
//				.getBean("op_InfoManagementServiceImpl");
//		List<Emp> emps = op_InfoManagementService.queryEmpByDepId(depId);// 根据页面传过来的部门编号查对应部门的医生
//		model.addAttribute("emps", emps);
//		return "op_showDocInDep";
//	}

	// 查科室编号对应的全部医生,加分页
	@RequestMapping("/op_showDocInDepPage/{depId}/{pageNum}")
	public String op_showDocInDepPage(@PathVariable("depId") String depId, @PathVariable("pageNum") int pageNum,
			Model model) {
		Op_InfoManagementService op_InfoManagementService = (Op_InfoManagementService) ac
				.getBean("op_InfoManagementServiceImpl");
		PageHelper.startPage(pageNum, 2);// 配置分页页码和页大小
		List<Emp> emps = op_InfoManagementService.queryEmpByDepId(depId);// 根据页面传过来的部门编号查对应部门的医生
		PageInfo<Emp> empsPage = new PageInfo<Emp>(emps);
		model.addAttribute("empsPage", empsPage);
		System.out.println(empsPage);
		return "op_showDocInDepPage";
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

		Op_RegistryService op_RegistryService = (Op_RegistryService) ac.getBean("op_RegistryServiceImpl");
		String cardId = (String) req.getSession().getAttribute("cardId");// 从session中获取就诊卡号
		try {
			OpRegistry opRegistry = op_RegistryService.newOpRegistry(empId, cardId);

			//session.invalidate();// 当前挂号完成后清空session
			model.addAttribute("msg", "挂号成功");
			return "op_msg";

		} catch (Exception e) {
			//session.invalidate();// 当前挂号完成后清空session
			model.addAttribute("msg", e.getMessage());
			return "op_msg";
		}

	}
}