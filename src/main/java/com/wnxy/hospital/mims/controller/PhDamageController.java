package com.wnxy.hospital.mims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wnxy.hospital.mims.entity.Damages;
import com.wnxy.hospital.mims.exception.PhMedicineException;
import com.wnxy.hospital.mims.service.ph.DamageService;

@Controller
public class PhDamageController {
	@Autowired
	DamageService damageService;
	
	@RequestMapping("/add/damage")
	public String addDamge(Model model,Damages damage) {
		try {
			int num = damageService.insertDamages(damage);
			model.addAttribute("msg", "新增成功");
			return "ph_damage.html";
		} catch (PhMedicineException e) {
			model.addAttribute("msg", "新增参数录入有误，请修改后重试！");
			return "ph_msg.html";
		}
	}
	@RequestMapping("/query/damage")
	public String queryDamage(Model model,Damages damage){
		try {
			if(damage.getMedicineId()==null||"".equals(damage.getMedicineId())) {
				damage.setDamageId("");
			}
			if(damage.getMedicineName()==null||"".equals(damage.getMedicineName())) {
				damage.setMedicineName("");
			}
			if(damage.getMedicineCount()==null||damage.getMedicineCount()==0) {
				damage.setMedicineCount(0);
			}
			if(damage.getStatus()==null) {
				damage.setStatus(1);
			}
			if(damage.getSource()==null||"".equals(damage.getSource())) {
				damage.setSource("");
			}
			List<Damages> damages = damageService.getDamageByCondition(damage);
			model.addAttribute("damages", damages);
			return "ph_damage.html";
		} catch (PhMedicineException e) {
			model.addAttribute("msg", "系统维护中,请稍后再试！");
			//model.addAttribute("msg", e);
			return "ph_msg.html";
		}
	}
}
