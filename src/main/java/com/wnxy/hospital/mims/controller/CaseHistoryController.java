package com.wnxy.hospital.mims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wnxy.hospital.mims.entity.OpCasehistory;
import com.wnxy.hospital.mims.service.op.impl.CaseHistoryServiceImple;

@Controller
@RequestMapping("/casehistory")
public class CaseHistoryController {
	
	@Autowired
	CaseHistoryServiceImple caseHistoryService;
	
	/**
	 * 创建病历
	 * @param casehistory
	 * @return
	 */
	@RequestMapping("/setCaseHistory")
	public String setCasetHistory(OpCasehistory casehistory) {
		try {
			caseHistoryService.createCaseHistory(casehistory);
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * 修改病历状态
	 * @param model
	 * @param caseid
	 * @param state
	 * @return
	 */
	@RequestMapping("/setCaseHistoryState")
	public String setCaseHistoryState(Model model, String caseid,Integer state) {
		try {
			// 判断State数值是否正确
			if(state<0||state>3) {
				return "";
			}
			//修改状态
			caseHistoryService.modifyCaseHistoryState(caseid, state);
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * 查询病历
	 * @param patientid
	 * @return
	 */
	@RequestMapping("/getCaseHistory")
	public String getCaseHistory(String patientid) {
		try {
			caseHistoryService.getCaseHistory(patientid);
			return "";
		}catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
