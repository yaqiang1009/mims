package com.wnxy.hospital.mims.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wnxy.hospital.mims.entity.PhDispatch;
import com.wnxy.hospital.mims.entity.PhMedicines;
import com.wnxy.hospital.mims.exception.PhMedicineException;
import com.wnxy.hospital.mims.service.ph.PhDispatchService;
import com.wnxy.hospital.mims.service.ph.PhMedicinesService;

@Controller
public class PhDispatchController {

	@Autowired
	PhDispatchService phDispatchService;
	@Autowired
	PhMedicinesService phMedicinesService;
	
	@RequestMapping("/add/dispatch")
	//新增调拨单
	public String addDispatch(Model model,PhDispatch pd) {
		try {
			System.out.println(pd);
			//添加主键
			pd.setDispatchId(UUID.randomUUID().toString());
			//添加默认状态为1--待处理
			pd.setStatus("1");
			//添加入库时间
			pd.setEnterDate(new Date());
			//根据药品名称查id
			PhMedicines pm = phMedicinesService.getMedicineByName(pd.getMedicineName());
			pd.setMedicineId(pm.getMedicineId());
			pd.setMedicineType(pm.getMedicineType());
			pd.setBatchNo(pm.getBatchNo());
			pd.setPrice(pm.getPrice());
			pd.setProduceDate(pm.getProduceDate());
			int num = phDispatchService.insertPhDispatch(pd);
			System.out.println(num);
			model.addAttribute("num", num);
			return "ph_dispatch.html";
		} catch (PhMedicineException e) {
			model.addAttribute("msg", "新增参数录入有误，请修改后重试！");
			return "ph_msg.html";
		}
	}
	
	//根据条件查询调拨单
	@RequestMapping("/query/dispatch/condition")
	public String queryDispatchCondition(Model model, PhDispatch pd) {
		try {
			if(pd==null) {
				pd = new PhDispatch();
			}
			List<PhDispatch> pds = phDispatchService.getDispatchBycondition(pd);
			model.addAttribute("pds", pds);
			model.addAttribute("pdd", pd);
			return "ph_dispatch.html";
		} catch (PhMedicineException e) {
			model.addAttribute("msg", "调拨部门繁忙，请稍后重试！");
			return "ph_msg.html";
		}
	}
	
	//查询全部调拨单
		@RequestMapping("/query/dispatch")
		public String queryAllDispatch(Model model) {
			try {
				List<PhDispatch> pds = phDispatchService.getAllDispatch();
				model.addAttribute("pds", pds);
				return "ph_dispatch.html";
			} catch (PhMedicineException e) {
				model.addAttribute("msg", "调拨部门繁忙，请稍后重试！");
				return "ph_msg.html";
			}
		}
}
