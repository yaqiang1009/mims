package com.wnxy.hospital.mims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wnxy.hospital.mims.entity.PhDispatch;
import com.wnxy.hospital.mims.service.ph.PhDispatchService;

@Controller
public class PhDispatchController {

	@Autowired
	PhDispatchService phDispatchService;
	
	@RequestMapping("/add/dispatch")
	public String addDispatch(Model model,PhDispatch pd) {
		
		phDispatchService.insertPhDispatch(pd);
		return null;
	}
}
