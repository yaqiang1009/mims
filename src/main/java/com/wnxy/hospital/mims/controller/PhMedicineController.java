package com.wnxy.hospital.mims.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.PhMedicines;
import com.wnxy.hospital.mims.entity.ph.page.PhPageBean;
import com.wnxy.hospital.mims.service.ph.PhMedicinesService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PhMedicineController {
	@Autowired
	PhMedicinesService phMedicinesService;
	// 分页设置
	int pageSize = 5;// 根据页面排版，一页只能展示5条，较为美观
	int indexSize = 5;// 默认展示分页数量为5个
	// 获取分页连接索引
	@RequestMapping("/page/{pageIndex}")
	public PhPageBean<PhMedicines> getPageIndex(@PathVariable("pageIndex") Integer 
			pageIndex,Model model,PhMedicines...pm ) {
		if (pageIndex == null) {
			pageIndex = 1;// 页索引，默认展示第一页
		}
		if(pm==null&&pm.length<=0) {
			queryAll(model);
		}
		if(pm!=null&&pm.length>0) {
			queryAllMedicine(pm[0], model);
		}
		return null;
	}

	@RequestMapping("/query/allmedicine")
	public String queryAllMedicine(PhMedicines pm, Model model) {
		// System.out.println(pm);
		int pageIndex = 1;// 默认展示第一页
		// 查询之前，先设置分页
		// 查询结果
		PhPageBean<PhMedicines> phpb = phMedicinesService.getMedicinesByCondition(pm, pageIndex, pageSize);
		phpb.setIndexSize(indexSize);
		model.addAttribute("phpb", phpb);
		return "ph_medicine_management.html";
	}

	@RequestMapping("/queryall")
	public String queryAll(Model model) {
		// this.pageNum = pageNum;
		// 查询之前，先设置分页
		int pageIndex = 1;// 默认展示第一页
		// 查询结果
		PhPageBean<PhMedicines> phpb = phMedicinesService.getAllMedicine(pageIndex, pageSize);
		phpb.setIndexSize(indexSize);
		model.addAttribute("phpb", phpb);
		return "ph_medicine_management.html";
	}
}
