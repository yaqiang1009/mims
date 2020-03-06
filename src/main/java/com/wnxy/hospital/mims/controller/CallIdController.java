package com.wnxy.hospital.mims.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wnxy.hospital.mims.entity.OpCallidlist;
import com.wnxy.hospital.mims.service.op.CallIdListService;

@Controller
@RequestMapping("/callid")
public class CallIdController {
	
	@Autowired
	CallIdListService callIdListService;
	/**
	 * 修改排号状态
	 * @param calllistid
	 * @param state
	 * @return
	 */
	@RequestMapping("/setcallList/{calllistid}")
	public String setcallIdList(@PathVariable String calllistid,@Param("state") Integer state) {
		try {
			callIdListService.modifiyCallIdList(calllistid, state);
			return "/";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * 插入新的排号
	 * @param model
	 * @param doctorid
	 * @return
	 */
	@RequestMapping("/getcallList")
	public String generiteCallIdList(String doctorid) {
		callIdListService.generiteCallIdList(doctorid);
		return "forward:/callid/setcallList";
	}
	
	/**
	 * 查询排号
	 * @param model
	 * @param doctorid
	 * @return
	 */
	@RequestMapping("/setcallList")
	public String setCallIdList(Model model, String doctorid) {
		List<OpCallidlist> callidlist = callIdListService.getCallIdList(doctorid);
		model.addAttribute("callidlist",callidlist);
		return "/outpatient/workbench";
	}
}
