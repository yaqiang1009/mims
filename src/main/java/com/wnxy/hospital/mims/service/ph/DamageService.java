package com.wnxy.hospital.mims.service.ph;

import java.util.List;

import com.wnxy.hospital.mims.entity.Damages;

public interface DamageService {
	//新增报损单
	int insertDamages(Damages damage);
	//查询单个报损表
	Damages getDamageById(String damageId);
	//根据条件查询报损表
	List<Damages> getDamageByCondition(Damages damage);
}
