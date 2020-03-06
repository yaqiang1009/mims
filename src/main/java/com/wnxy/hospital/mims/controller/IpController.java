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

import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.IpBed;
import com.wnxy.hospital.mims.entity.IpCashPledge;
import com.wnxy.hospital.mims.entity.IpCashUse;
import com.wnxy.hospital.mims.entity.IpDrug;
import com.wnxy.hospital.mims.entity.IpHospitalized;
import com.wnxy.hospital.mims.entity.IpIllness;
import com.wnxy.hospital.mims.entity.IpLeaveapply;
import com.wnxy.hospital.mims.entity.IpPaymentOrder;
import com.wnxy.hospital.mims.entity.IpRemedy;
import com.wnxy.hospital.mims.entity.IpWard;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.mapper.IpBedMapper;
import com.wnxy.hospital.mims.service.Ip_Cash_Pledge;
import com.wnxy.hospital.mims.service.Ip_DrService;
import com.wnxy.hospital.mims.service.Ip_HosOrderService;
import com.wnxy.hospital.mims.service.Ip_RemedyService;
import com.wnxy.hospital.mims.service.Ip_bedService;
import com.wnxy.hospital.mims.service.Ip_empService;
import com.wnxy.hospital.mims.service.Ip_wardService;
import com.wnxy.hospital.mims.service.Ip_LeaveHospService;
import com.wnxy.hospital.mims.service.Ip_Patient;
import com.wnxy.hospital.mims.service.impl.Ip_DrServiceImpl;
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
		System.out.println(IpIllnessp.getList().size());
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
