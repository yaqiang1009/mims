package com.wnxy.hospital.mims.service.stock;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.StMedicines;

public interface StMedicinesService {
	StMedicines selectById(String mid);
	List<StMedicines> selectAll();
	List<StMedicines> selectByName(String name);
}
