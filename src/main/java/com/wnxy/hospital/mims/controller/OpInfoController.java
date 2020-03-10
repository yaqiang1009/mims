package com.wnxy.hospital.mims.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.Office;
import com.wnxy.hospital.mims.entity.OpDep;
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
			//session.invalidate();// 添加成功后清空session
			model.addAttribute("msg", "部门添加成功");
			return "op_msg";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "op_msg";
		}
	}

	// 查询所有部门
	@RequestMapping("/op_queryAllOffice")
	public String op_queryAllOffice(Model model) {
		Op_InfoManagementService op_InfoManagementService = (Op_InfoManagementService) ac
				.getBean("op_InfoManagementServiceImpl");
		try {
			List<Office> allOffice = op_InfoManagementService.queryAllOffice();
			model.addAttribute("allOffice", allOffice);
			return "op_showAllOffice";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "op_msg";
		}
	}

	// 接收部门id，将查出来的部门信息存到域里以供修改页面使用
	@RequestMapping("/op_officeDetail/{officeId}")
	public String op_officeDetail(@PathVariable("officeId") String officeId, Model model) {
		Op_InfoManagementService op_InfoManagementService = (Op_InfoManagementService) ac
				.getBean("op_InfoManagementServiceImpl");
		try {
			Office office = op_InfoManagementService.queryOfficeByOfficeId(officeId);
			System.out.println("查到的部门:" + office);
			model.addAttribute("office", office);
			return "op_officeAlter";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "op_msg";
		}
	}

	// 修改部门信息
	@RequestMapping("/op_officeAlter")
	public String op_officeAlter(Office office, Model model) {
		Op_InfoManagementService op_InfoManagementService = (Op_InfoManagementService) ac
				.getBean("op_InfoManagementServiceImpl");
		try {
			op_InfoManagementService.updateOfficeByOfficeId(office);
			System.out.println("修改后的部门信息:" + office);
			model.addAttribute("msg", "部门信息修改成功");
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
			//session.invalidate();// 添加成功后清空session
			model.addAttribute("msg", "科室添加成功");
			return "op_msg";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "op_msg";
		}
	}

	// 查询所有科室
	@RequestMapping("/op_queryAllDepForManage")
	public String op_queryAllDepForManage(Model model) {
		Op_InfoManagementService op_InfoManagementService = (Op_InfoManagementService) ac
				.getBean("op_InfoManagementServiceImpl");
		try {
			List<OpDep> allDep = op_InfoManagementService.queryAllOpDep();
			model.addAttribute("allDep", allDep);
			return "op_showAllDepForManage";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "op_msg";
		}
	}

	// 接收科室id，将查出来的科室信息存到域里以供修改页面使用
	@RequestMapping("/op_depDetail/{depId}")
	public String op_depDetail(@PathVariable("depId") String depId, Model model) {
		Op_InfoManagementService op_InfoManagementService = (Op_InfoManagementService) ac
				.getBean("op_InfoManagementServiceImpl");
		try {
			OpDep opDep = op_InfoManagementService.queryOpDepByDepId(depId);
			System.out.println("查到的科室:" + opDep);
			model.addAttribute("opDep", opDep);
			return "op_depAlter";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "op_msg";
		}
	}

	// 修改科室
	@RequestMapping("/op_depAlter")
	public String op_depAlter(OpDep opDep, Model model) {
		Op_InfoManagementService op_InfoManagementService = (Op_InfoManagementService) ac
				.getBean("op_InfoManagementServiceImpl");
		try {
			op_InfoManagementService.updateOpDepByDepId(opDep);
			System.out.println("修改后的科室信息:" + opDep);
			model.addAttribute("msg", "科室信息修改成功");
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
			//session.invalidate();// 添加成功后清空session
			model.addAttribute("msg", "收费等级添加成功");
			return "op_msg";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "op_msg";
		}
	}

	// 查询所有已有挂号收费等级的医生
	@RequestMapping("/op_showAllDocInLevel")
	public String op_showAllDocInLevel(Model model) {
		Op_InfoManagementService op_InfoManagementService = (Op_InfoManagementService) ac
				.getBean("op_InfoManagementServiceImpl");
		try {
			List<OpDoclevel> opDoclevels = op_InfoManagementService.queryAllOpDoclevel();
			System.out.println("查询到的已有收费等级:" + opDoclevels);
			List<Emp> allEmp = new ArrayList<Emp>();
			for (OpDoclevel level : opDoclevels) {
				allEmp.add(op_InfoManagementService.queryEmpByEmpId(level.getEmpId()));
			}

			System.out.println("查询到的已有收费等级的医生:" + allEmp);
			model.addAttribute("allEmp", allEmp);
			return "op_showAllDocInLevel";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "op_msg";
		}
	}

	// 接收医生empId，将查出来的收费等级信息存到域里以供修改页面使用
	@RequestMapping("/op_showDocLevel/{empId}")
	public String op_levelAlter(@PathVariable("empId") String empId, Model model) {
		Op_InfoManagementService op_InfoManagementService = (Op_InfoManagementService) ac
				.getBean("op_InfoManagementServiceImpl");
		try {
			OpDoclevel opDoclevel = op_InfoManagementService.queryOpDoclevelByEmpId(empId).get(0);

			System.out.println("查到的收费等级:" + opDoclevel);
			model.addAttribute("opDoclevel", opDoclevel);
			return "op_alterDocLevel";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "op_msg";
		}
	}

	// 修改收费等级
	@RequestMapping("/op_alterDocLevel")
	public String op_alterDocLevel(OpDoclevel opDoclevel, Model model) {
		Op_InfoManagementService op_InfoManagementService = (Op_InfoManagementService) ac
				.getBean("op_InfoManagementServiceImpl");
		try {
			op_InfoManagementService.updateOpDoclevelByDlId(opDoclevel);

			System.out.println("页面传过来的收费等级:" + opDoclevel);
			model.addAttribute("msg", "修改成功");
			return "op_msg";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "op_msg";
		}
	}

}