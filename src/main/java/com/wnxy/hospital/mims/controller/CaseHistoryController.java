package com.wnxy.hospital.mims.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wnxy.hospital.mims.entity.OpCasehistory;
import com.wnxy.hospital.mims.entity.OpTreatment;
import com.wnxy.hospital.mims.service.op.impl.CaseHistoryServiceImple;
import com.wnxy.hospital.mims.service.op.impl.TreatmentServiceImpl;
import com.wnxy.hospital.mims.utils.MyUuid;

@Controller
@RequestMapping("/casehistory")
public class CaseHistoryController {

	@Autowired
	CaseHistoryServiceImple caseHistoryService;

	@Autowired
	TreatmentServiceImpl treatmentservice;

	/**
	 * 创建病历
	 * 
	 * @param casehistory
	 * @return
	 */
	@RequestMapping("/setCaseHistory")
	@ResponseBody
	public String setCasetHistory(@RequestBody Map<String, String> map) {
		try {
			OpTreatment treatment = treatmentservice.getTreatment(0);
			String patientid = map.get("patientid");
			String description = map.get("description");
			OpCasehistory opcase = new OpCasehistory(MyUuid.getMyUuid(), patientid, treatment.getTmId(), description,
					new Date(), 0);
			/* String caseid = caseHistoryService.createCaseHistory(opcase); */
			return opcase.getCaseId();
		} catch (Exception e) {
			e.printStackTrace();
			return "写入失败";
		}
	}

	/**
	 * 修改病历状态
	 * 
	 * @param model
	 * @param caseid
	 * @param state
	 * @return
	 */
	@RequestMapping("/setCaseHistoryState")
	public String setCaseHistoryState(Model model, String caseid, Integer state) {
		try {
			// 判断State数值是否正确
			if (state < 0 || state > 3) {
				return "修改失败";
			}
			// 修改状态
			caseHistoryService.modifyCaseHistoryState(caseid, state);
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			return "修改失败";
		}
	}

	/**
	 * 查询病历
	 * 
	 * @param patientid
	 * @return
	 */
	@RequestMapping("/getCaseHistory")
	public List<OpCasehistory> getCaseHistory(String patientid) {
		try {
			List<OpCasehistory> caseHistory = caseHistoryService.getCaseHistory(patientid);
			return caseHistory;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
