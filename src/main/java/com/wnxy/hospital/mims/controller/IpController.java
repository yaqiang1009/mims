package com.wnxy.hospital.mims.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.IpBed;
import com.wnxy.hospital.mims.entity.IpCashPledge;
import com.wnxy.hospital.mims.entity.IpCashUse;
import com.wnxy.hospital.mims.entity.IpDrug;
import com.wnxy.hospital.mims.entity.IpDrugDetail;
import com.wnxy.hospital.mims.entity.IpHospitalized;
import com.wnxy.hospital.mims.entity.IpIllness;
import com.wnxy.hospital.mims.entity.IpLeaveapply;
import com.wnxy.hospital.mims.entity.IpPaymentOrder;
import com.wnxy.hospital.mims.entity.IpRemedy;
import com.wnxy.hospital.mims.entity.IpWard;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.entity.PhMedicines;
import com.wnxy.hospital.mims.entity.PhOutMedicine;
import com.wnxy.hospital.mims.entity.UserPsd;
import com.wnxy.hospital.mims.entity.ph.page.PhPageBean;
import com.wnxy.hospital.mims.service.Ip_Cash_Pledge;
import com.wnxy.hospital.mims.service.Ip_DrService;
import com.wnxy.hospital.mims.service.Ip_HosOrderService;
import com.wnxy.hospital.mims.service.Ip_LeaveHospService;
import com.wnxy.hospital.mims.service.Ip_Patient;
import com.wnxy.hospital.mims.service.Ip_RemedyService;
import com.wnxy.hospital.mims.service.Ip_bedService;
import com.wnxy.hospital.mims.service.Ip_empService;
import com.wnxy.hospital.mims.service.Ip_wardService;
import com.wnxy.hospital.mims.service.ip.Ip_DrugDetailService;
import com.wnxy.hospital.mims.service.ip.Ip_DrugService;
import com.wnxy.hospital.mims.service.ip.Ip_IllnessService;
import com.wnxy.hospital.mims.service.ip.Ip_LeaveapplyService;
import com.wnxy.hospital.mims.service.ph.OutMedicinesService;
import com.wnxy.hospital.mims.service.ph.PhMedicinesService;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
//处理器
@Slf4j
@Controller
public class IpController {
	@Resource
	@Setter private ApplicationContext ac;
	//检索全部住院订单
	//@RequiresPermissions("dco:all")
	@RequestMapping("/ip_hosporder")
	public String ip_HospOrder(int index,Model model,HttpServletRequest request) {
		Ip_HosOrderService ip_HosOrderService =(Ip_HosOrderService) ac.getBean("ip_HosOrderServiceImpl");
		PageInfo<IpHospitalized> ipHospitalizeds = ip_HosOrderService.selectAllHos(index);
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
		return "redirect:/ip_hosporder?index=1";
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
	//添加医疗单时异步请求空余床位信息
	@ResponseBody
	@RequestMapping("/word_bed")
	public Object word_Bed(String wardId) {
		Ip_bedService ip_bedService =(Ip_bedService)ac.getBean("ip_bedServiceImpl");
		List<IpBed> beds = ip_bedService.selectBed(wardId); 
		return beds;
	}
	//入院,完成住院订单，添加医疗单，押金单
	@RequestMapping("/Hos_pass_sub")
	public String hos_Pass_Sub(String id,String empId,String wardId,String bedId,Model model) {
		Ip_HosOrderService ip_HosOrderService =(Ip_HosOrderService) ac.getBean("ip_HosOrderServiceImpl");
		//查询
		try {
			ip_HosOrderService.overOrder(id, empId, wardId, bedId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/ip_hosporder?index=1";
	}
	//************************出院审核
	//检索出院申请信息
	@RequestMapping("/leaveHospOrder")
	public String leaveHospOrder(Integer index,Model model) {
		//获取对象，调方法
		Ip_LeaveHospService ieavehospService = (Ip_LeaveHospService)ac.getBean("ip_LeaveHospServiceImpl");
		PageInfo<IpLeaveapply> IpLeaveapplys = ieavehospService.selectAllLeave(index);
		model.addAttribute("IpLeaveapplys",IpLeaveapplys);
		return "ip_leavehosp";
	}
	//通过出院申请
	@RequestMapping("/leave/pass/{id}")
	public String leavePass(@PathVariable("id") String id) {
		//修改订单状态
		Ip_LeaveHospService ieavehospService = (Ip_LeaveHospService)ac.getBean("ip_LeaveHospServiceImpl");
		ieavehospService.leavePass(id);
		return "redirect:/leaveHospOrder?index=1";
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
		return "redirect:/leaveHospOrder?index=1";
	}
	//*************************医疗单相关
	//住院中医疗单全部查询
	@RequestMapping("/ip_selectremedy")
	public String ip_SelectRemedy(int index,Model model) {
		Ip_RemedyService remedy = (Ip_RemedyService)ac.getBean("ip_RemedyServiceImpl");
		PageInfo<IpRemedy> remedys = remedy.selectAllRemedy("",index);
		model.addAttribute("remedys", remedys);
		return "ip_remedy";
	}
	//住院中医疗单病人姓名模糊查询
	@RequestMapping("/ip_selectremedyPtName")
	public String ip_SelectRemedy_ptName(String name,Model model) {
		Ip_RemedyService remedy = (Ip_RemedyService)ac.getBean("ip_RemedyServiceImpl");
		PageInfo<IpRemedy> remedys = remedy.selectAllRemedyPtName(name);
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
		return "redirect:/ip_selectremedy?index=1";
	}
	//*************************病床
	//新增修改床位，检索信息
	@RequestMapping("/ip_bed_alter")
	public String bedAlter(Model model) {
		//检索全部病房
		Ip_wardService ip_wardService = (Ip_wardService)ac.getBean("ip_wardServiceImpl");
		List<IpWard> wards = ip_wardService.selectAllWard();
		model.addAttribute("wards", wards);
		//检索全部床位
		Ip_bedService ip_bedService = (Ip_bedService)ac.getBean("ip_bedServiceImpl");
		List<IpBed> allBed = ip_bedService.selectAllBed();
		model.addAttribute("allBedNum", allBed.size());
		List<IpBed> leiBed = ip_bedService.selectLeiAllBed();
		model.addAttribute("leiBedNum", leiBed.size());
		return "ip_bed_alter";
	}
	//修改床位异步请求所有床位信息
	@ResponseBody
	@RequestMapping("/word_allbed")
	public Object word_AllBed(String wardId) {
		Ip_bedService ip_bedService =(Ip_bedService)ac.getBean("ip_bedServiceImpl");
		List<IpBed> beds = ip_bedService.selectWardAllBed(wardId); 
		return beds;
	}
	//修改床位，修改数据库
	@RequestMapping("/bed_alter_sub")
	public String bedAlterSub(String bedIdFor,String wardIdTo,int bedNum,Model model) {
		//修改
		Ip_bedService ip_bedService = (Ip_bedService)ac.getBean("ip_bedServiceImpl");
		ip_bedService.alterBed(bedIdFor, wardIdTo, bedNum);
		return "redirect:/ip_bed_alter";
	}
	//新增床位，修改数据库
	@RequestMapping("/bed_create_sub")
	public String bedCreateSub(String createWardId,int createBedNum,Model model) {
		//修改
		Ip_bedService ip_bedService = (Ip_bedService)ac.getBean("ip_bedServiceImpl");
		ip_bedService.createBed(createWardId, createBedNum);
		return "redirect:/ip_bed_alter";
	}
	//********************病人资料相关
	//查询所有住院病人信息
	@RequestMapping("/ip_patient")
	public String ipPatient(Model model,int index) {
		//查询
		Ip_Patient ip_Patient = (Ip_Patient)ac.getBean("ip_PatientImpl");
		PageInfo<OpPatientinfo> pts = ip_Patient.selectNowPatient(index);
		model.addAttribute("pts", pts);
		return "ip_patient";
	}
	//查询指定病人信息
	@RequestMapping("/patient_select/{id}")
	public String ipPatient(@PathVariable("id") String id,Model model) {
		//查询
		Ip_Patient ip_Patient = (Ip_Patient)ac.getBean("ip_PatientImpl");
		OpPatientinfo pt = ip_Patient.selectNowPtId(id);
		model.addAttribute("pt", pt);
		return "ip_patient_alter";
	}
	//修改病人信息
	@RequestMapping("/patient_alter_sub")
	public String patientAlter(String id,String phone,String familyperson,String familyphone,String address,Model model) {
		//修改
		Ip_Patient ip_Patient = (Ip_Patient)ac.getBean("ip_PatientImpl");
		ip_Patient.alterPt(id, phone, familyperson, familyphone, address);
		return "redirect:/ip_patient";
	}
	//******************************药单相关
	//今日全部药单检索
	@RequestMapping("/ip_nowdrgu")
	public String ipNowDrgu(int index,Model model) {
		//查找
		Ip_DrService ip_DrService = (Ip_DrService)ac.getBean("ip_DrServiceImpl");
		PageInfo<IpDrug> ipDrugs = ip_DrService.selectNowAllDr(index);
		model.addAttribute("ipDrugs", ipDrugs);
		return "ip_nowdrgu";
	}
	//全部医疗单检索
	@RequestMapping("/ip_historydrgu")
	public String ipHistoryDrgu(int index,Model model) {
		//查找
		Ip_RemedyService ip_RemedyService = (Ip_RemedyService)ac.getBean("ip_RemedyServiceImpl");
		PageInfo<IpRemedy> ipRemedys = ip_RemedyService.selectHisAllRemedy("", index);
		model.addAttribute("remedys", ipRemedys);
		return "ip_historydrgu";
	}
	//全部医疗单病人姓名模糊检索
	@RequestMapping("/ip_historydrgupt")
	public String ipHistoryDrguToPtName(String name,int index,Model model) {
		//查找
		Ip_RemedyService ip_RemedyService = (Ip_RemedyService)ac.getBean("ip_RemedyServiceImpl");
		PageInfo<IpRemedy> ipRemedys = ip_RemedyService.selectHisAllRemedy(name, index);
		model.addAttribute("remedys", ipRemedys);
		model.addAttribute("ptName", name);
		return "ip_historydrgu";
	}
	//指定医疗单历史药单
	@RequestMapping("/ip_historydrgu_detail/{id}/{index}")
	public String ipHistoryDrguDetail(@PathVariable("id") String id,@PathVariable("index") int index,Model model) {
		//查找当前页面所有病情单
		Ip_DrService ip_DrService = (Ip_DrService)ac.getBean("ip_DrServiceImpl");
		PageInfo<IpIllness> IpIllnessp = ip_DrService.selectIpIllnesss(id, index);
		model.addAttribute("IpIllnessp", IpIllnessp);
		//查找医疗单信息
		Ip_RemedyService ip_RemedyService = (Ip_RemedyService)ac.getBean("ip_RemedyServiceImpl");
		IpRemedy remedy = ip_RemedyService.selectRemedy(id);
		model.addAttribute("remedy", remedy);
		model.addAttribute("id", id);
		return "ip_historydrgu_detail";
	}
	//所有用户押金表
	@RequestMapping("/ip_cash_pledge/{index}")
	public String ipCashPledge(String name,@PathVariable("index") int index,Model model) {
		//查询所有押金
		Ip_Cash_Pledge ip_Cash_Pledge = (Ip_Cash_Pledge)ac.getBean("ip_Cash_PledgeImpl");
		PageInfo<IpCashPledge> IpCashPledges = ip_Cash_Pledge.selectAllCash(name, index);
		model.addAttribute("IpCashPledges", IpCashPledges);
		model.addAttribute("name", name);
		return "ip_cash_pledge";
	}
	//用户缴费
	@RequestMapping("/ip_cash_bargain")
	public String ipCashBargain(String cashId,Double price,Model model) {
		//缴费
		Ip_Cash_Pledge ip_Cash_Pledge = (Ip_Cash_Pledge)ac.getBean("ip_Cash_PledgeImpl");
		ip_Cash_Pledge.cashBargain(cashId, price);
		return "redirect:/ip_cash_pledge/1?name=";
	}
	//查询缴费记录
	@RequestMapping("/ip_bargain_his")
	public String ipBargainHis(String ptId,int index,Model model) {
		//缴费单
		Ip_Cash_Pledge ip_Cash_Pledge = (Ip_Cash_Pledge)ac.getBean("ip_Cash_PledgeImpl");
		PageInfo<IpPaymentOrder> IpPaymentOrderp = ip_Cash_Pledge.selectBargainHis(ptId, index);
		model.addAttribute("IpPaymentOrderp", IpPaymentOrderp);
		//检索病人信息
		Ip_Patient ip_Patient = (Ip_Patient)ac.getBean("ip_PatientImpl");
		OpPatientinfo pt = ip_Patient.selectNowPtId(ptId);
		model.addAttribute("pt", pt);
		return "ip_bargain_his";
	}
	//查询押金使用记录
	@RequestMapping("/ip_cashuse_his")
	public String ipCashuseHis(String ptId,int index,Model model) {
		//使用单
		Ip_Cash_Pledge ip_Cash_Pledge = (Ip_Cash_Pledge)ac.getBean("ip_Cash_PledgeImpl");
		PageInfo<IpCashUse> IpCashUsep = ip_Cash_Pledge.selectBargainUseHis(ptId, index);
		model.addAttribute("IpCashUsep", IpCashUsep);
		//检索病人信息
		Ip_Patient ip_Patient = (Ip_Patient)ac.getBean("ip_PatientImpl");
		OpPatientinfo pt = ip_Patient.selectNowPtId(ptId);
		model.addAttribute("pt", pt);
		return "ip_cashuse_his";
	}
	
	//********************医生相关
	//住院医生查询我的病人
	@RequestMapping("/ip_mypatient")
	public String ip_mypatient(int index,Model model,HttpServletRequest req) {
		Ip_RemedyService remedy = (Ip_RemedyService)ac.getBean("ip_RemedyServiceImpl");
		//从session中获取当前登录医生对象
		UserPsd userpsd = (UserPsd) req.getSession().getAttribute("nowUser");
		//PageInfo<IpRemedy> remedys = remedy.selectAllRemedy(userpsd.getEmpId(),index);
		PageInfo<IpRemedy> remedys = remedy.selectAllRemedy("1",index);
		model.addAttribute("remedys", remedys);
		return "ip_mypatient";
	}
	//住院医生填写申请出院单
	@RequestMapping("/ip_leaveorder/{id}")
	public String ip_leaveorder(@PathVariable("id") String remedyId,Model model) {
		//检索医疗单信息
		Ip_RemedyService remedyService = (Ip_RemedyService)ac.getBean("ip_RemedyServiceImpl");
		IpRemedy selectRemedy = remedyService.selectRemedy(remedyId);
		model.addAttribute("selectRemedy", selectRemedy);
		return "ip_leaveorder";
	}
	//住院医生提交申请出院单
	@RequestMapping("/ip_addleaveorder")
	public String ip_addleaveorder(HttpServletRequest req,Model model) {
		//获取参数
		String remedyId = req.getParameter("id");
		String illness = req.getParameter("illness");
		String cause = req.getParameter("cause");
		//检索医疗单信息
		Ip_RemedyService remedyService = (Ip_RemedyService)ac.getBean("ip_RemedyServiceImpl");
		IpRemedy remedy = remedyService.selectRemedy(remedyId);
		//出院单对象赋值
		IpLeaveapply leaveapply = new IpLeaveapply();
		leaveapply.setEmpId(remedy.getEmpId());
		leaveapply.setRemedyId(remedyId);
		leaveapply.setIllness(illness);
		leaveapply.setCause(cause);
		//插入数据
		Ip_LeaveapplyService leaveapplyService = (Ip_LeaveapplyService)ac.getBean("ip_LeaveapplyServiceImpl");
		leaveapplyService.addLeaveapplyOrder(leaveapply);
		return "redirect:/ip_mypatient?index=1";
	}
	//住院医生查询住院医疗单
	@RequestMapping("/ip_select_myremedy")
	public String ip_SelectMyRemedy(int index,Model model,HttpServletRequest req) {
		Ip_RemedyService remedy = (Ip_RemedyService)ac.getBean("ip_RemedyServiceImpl");
		//从session中获取当前登录医生对象
		UserPsd userpsd = (UserPsd) req.getSession().getAttribute("nowUser");
		System.out.println(userpsd);
		//PageInfo<IpRemedy> remedys = remedy.selectAllRemedy(userpsd.getEmpId(),index);
		PageInfo<IpRemedy> remedys = remedy.selectAllRemedy("1",index);
		model.addAttribute("remedys", remedys);
		return "ip_select_myremedy";
	}
	//指定医疗单,检索病情单信息
	@RequestMapping("/ip_select_allillness/{id}")
	public String ip_SelectAllIllness(@PathVariable("id") String remedyId,int index,Model model) {
		//检索病情单信息
		Ip_IllnessService illnessService = (Ip_IllnessService)ac.getBean("ip_IllnessServiceImpl");
		PageInfo<IpIllness> allillness = illnessService.selectAllIpIllnessByRemedyId(remedyId, index);
		model.addAttribute("allillness", allillness);
		//返回姓名
		Ip_RemedyService remedyService = (Ip_RemedyService)ac.getBean("ip_RemedyServiceImpl");
		IpRemedy selectRemedy = remedyService.selectRemedy(remedyId);
		model.addAttribute("ptname", selectRemedy.getOpPatientinfo().getPtName());
		return "ip_select_allillness";
	}
	//查询药单详情
	@RequestMapping("/ip_drugdetail/{id}")
	public String ip_drugdetail(@PathVariable("id") String illnessId,Model model) {
		Ip_DrugService drugService = (Ip_DrugService)ac.getBean("ip_DrugServiceImpl");
		IpDrug drug = drugService.selectDrugByIllnessId(illnessId);
		Ip_DrugDetailService drugDetailService = (Ip_DrugDetailService)ac.getBean("ip_DrugDetailServiceImpl");
		List<IpDrugDetail> drugDetails = drugDetailService.selectAllDrugDetailsByDrugId(drug.getDrugId());
		model.addAttribute("drug", drug);
		model.addAttribute("drugDetails", drugDetails);
		//提供返回上一步的参数--医疗单ID
		Ip_IllnessService illnessService = (Ip_IllnessService)ac.getBean("ip_IllnessServiceImpl");
		IpIllness selectIpIllness = illnessService.selectIpIllnessById(illnessId);
		String remedyId = selectIpIllness.getRemedyId();
		model.addAttribute("remedyId", remedyId);
		return "ip_drugdetail";
	}
	//住院医生医疗单仅住院中的可查询诊断
	@RequestMapping("/ip_doremedy")
	public String ip_doremedy(int index,Model model,HttpServletRequest req) {
		Ip_RemedyService remedy = (Ip_RemedyService)ac.getBean("ip_RemedyServiceImpl");
		//从session中获取当前登录医生对象
		UserPsd userpsd = (UserPsd) req.getSession().getAttribute("nowUser");
		System.out.println(userpsd);
		//PageInfo<IpRemedy> remedys = remedy.selectAllRemedy(userpsd.getEmpId(),index);
		PageInfo<IpRemedy> remedys = remedy.selectSomeRemedy("1", index);
		model.addAttribute("remedys", remedys);
		return "ip_doremedy";
	}
	//住院医生填写病情表页面
	@RequestMapping("/ip_add_illnessorder/{id}")
	public String ip_add_illnessorder(@PathVariable("id") String remedyId,Model model,HttpServletRequest req) {
		//检索医疗单信息
		Ip_RemedyService ip_RemedyService = (Ip_RemedyService)ac.getBean("ip_RemedyServiceImpl");
		IpRemedy remedy = ip_RemedyService.selectRemedy(remedyId);
		model.addAttribute("remedy", remedy);
		//检索当前药房所有药
		PhMedicinesService medicinesService = (PhMedicinesService)ac.getBean("phMedicinesServiceImpl");
		List<PhMedicines> allMedicine = medicinesService.getAllMedicine();
		model.addAttribute("allMedicine",allMedicine);
		return "ip_add_illnessorder";
	}
	//修改药品异步请求单价
	@ResponseBody
	@RequestMapping("/medicine")
	public Object medicine_price(String medicineId) {
		PhMedicinesService medicinesService = (PhMedicinesService)ac.getBean("phMedicinesServiceImpl");
		PhMedicines medicine = medicinesService.getMedicineById(medicineId);
		return medicine;
	}
	//住院医生提交病情表
	@RequestMapping("/ip_add_allorder")
	public String ip_add_allorder(Model model,HttpServletRequest req) {
		//添加病情单
		String remedyId = req.getParameter("remedyId");
		String illness = req.getParameter("illness");
		String caution = req.getParameter("caution");
		IpIllness ipIllness=new IpIllness();
		ipIllness.setCaution(caution);
		ipIllness.setIllness(illness);
		Ip_IllnessService illnessService = (Ip_IllnessService)ac.getBean("ip_IllnessServiceImpl");
		String addIllnessOrder = illnessService.addIllnessOrder(ipIllness, remedyId);
		//病情单插入成功
		if(addIllnessOrder.equals("插入成功")) {
			//添加药单
			Ip_DrugService drugService = (Ip_DrugService)ac.getBean("ip_DrugServiceImpl");
			IpDrug ipDrug=new IpDrug();
			String addDrugOrder = drugService.addDrugOrder(ipDrug, ipIllness.getIllnessId());
			//药单插入成功
			if(addDrugOrder.equals("插入成功")) {
				//添加药单明细
				String medicineId = req.getParameter("medicineId");
				Integer drugNum = Integer.parseInt(req.getParameter("drugNum"));
				Double price =Double.parseDouble(req.getParameter("price"));
				String useInstructions = req.getParameter("useInstructions");
				IpDrugDetail ipDrugDetail=new IpDrugDetail();
				ipDrugDetail.setDrugNum(drugNum);
				ipDrugDetail.setMedicineId(medicineId);
				ipDrugDetail.setPrice(price);
				ipDrugDetail.setUseInstructions(useInstructions);
				List<IpDrugDetail> ipDrugDetails= new ArrayList<IpDrugDetail>();
				ipDrugDetails.add(ipDrugDetail);
				Ip_DrugDetailService drugDetailService = (Ip_DrugDetailService)ac.getBean("ip_DrugDetailServiceImpl");
				String addDrugDetailOrder = drugDetailService.addDrugDetailOrder(ipDrugDetails, ipDrug.getDrugId());
				//查询现在的药单状态
				IpDrug selectDrugByDrugId = drugService.selectDrugByDrugId(ipDrug.getDrugId());
				//药单插入成功，且扣费成功
				if(selectDrugByDrugId.getDrugStatus().equals("待取药")) {
					//药单提交药房
					OutMedicinesService outMedicinesService = (OutMedicinesService)ac.getBean("outMedicinesServiceImpl");
					PhOutMedicine pom=new PhOutMedicine();
					pom.setDrugId(ipDrug.getDrugId());
					pom.setSubtotal(price);
					List<PhOutMedicine> poms=new ArrayList<PhOutMedicine>();
					poms.add(pom);
					outMedicinesService.insertOutMedicineList(poms);
					System.out.println("pom"+pom);
				}
			}
		}
		return "redirect:/ip_doremedy?index=1";
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
