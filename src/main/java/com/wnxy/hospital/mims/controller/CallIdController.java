package com.wnxy.hospital.mims.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.dto.CallIdItemDTO;
import com.wnxy.hospital.mims.service.impl.Op_Ip_OrderImpl;
import com.wnxy.hospital.mims.service.op.CallIdListService;

@Controller
@RequestMapping("/callid")
public class CallIdController {

	@Autowired
	CallIdListService callIdListService;

	@Autowired
	Op_Ip_OrderImpl iporderService;
	
	/**
	 * 修改排号状态
	 * 
	 * @param calllistid
	 * @param state
	 * @return
	 */
	@RequestMapping("/setcallId")
	@ResponseBody
	public String setcallId(@RequestBody Map<String, String> map) {
		try {
			String calllistid = map.get("calllistid");
			Integer state = Integer.parseInt(map.get("state"));
			callIdListService.modifiyCallIdList(calllistid, state);
			return "病人叫号操作成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}

	/**
	 * 插入新的排号
	 * 
	 * @param model
	 * @param doctorid
	 * @return
	 */
	@RequestMapping("/getcallList")
	public String generiteCallIdList(@RequestBody Map<String, String> map,HttpServletRequest request) {
		int pageIndex = Integer.parseInt(map.get("pageIndex"));
		String doctorid = map.get("empid");
		request.setAttribute("pageIndex",pageIndex);
		request.setAttribute("doctorid",doctorid);
		try {
			callIdListService.generiteCallIdList(doctorid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:/callid/setcallList";
	}

	/**
	 * 查询排号
	 * 
	 * @param model
	 * @param doctorid
	 * @return
	 */
	@RequestMapping("/setcallList")
	@ResponseBody
	public Object setCallIdList(HttpServletRequest request) {
		// 分页信息
		int pageIndex = Integer.parseInt(request.getAttribute("pageIndex").toString());
		String doctorid = request.getAttribute("doctorid").toString();
		int datanum = callIdListService.getdatanum(doctorid);
		PageHelper.startPage(pageIndex, 5);
		PageHelper.orderBy("date asc");
		try {
			List<CallIdItemDTO> callIdList = callIdListService.getCallIdList(doctorid);
			PageInfo<CallIdItemDTO> callidlist = new PageInfo<CallIdItemDTO>(callIdList);
			//总条数
			callidlist.setTotal(datanum);
			//总页数
			if(datanum%5==0) {
				callidlist.setPages(datanum/5);
			}else {
				callidlist.setPages(datanum/5+1);
			}
			return callidlist;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/inpatientorder")
	@ResponseBody
	public String setInpatientOrder(@RequestBody Map<String, String> map) {
		String pt_id = map.get("patientid");
		String emp_id = map.get("empid");
		String illness = map.get("desciption");
		try {
			/* iporderService.addOrder(pt_id , emp_id , illness); */
			System.out.println(pt_id);
			System.out.println(emp_id);
			System.out.println(illness);
			return "住院请求发送成功";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
