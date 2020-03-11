package com.wnxy.hospital.mims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wnxy.hospital.mims.entity.PhMedicineInventory;
import com.wnxy.hospital.mims.exception.PhMedicineException;
import com.wnxy.hospital.mims.service.ph.PhInventoryService;
@Controller
public class PhInventoryController {
	@Autowired
	PhInventoryService PhInventoryService;
	
	@RequestMapping("/query/inventory")
	public String queryInventory(Model model,PhMedicineInventory pmi) {
//		if(pmi.getId()==null) pmi.setId("");
//		if(pmi.getMedicineId()==null) pmi.setMedicineId("");
//		if(pmi.getMedicineName()==null) pmi.setMedicineName("");
		try {
			if(pmi==null) {
				pmi = new PhMedicineInventory();
			}
			List<PhMedicineInventory> pmis = PhInventoryService.getInventory(pmi);
			model.addAttribute("pmis", pmis);
			return "ph_inventory";
		} catch (PhMedicineException e) {
			model.addAttribute("msg", "仓库维护中，请稍后再试！");
			return "ph_msg";
		}
	}
}
