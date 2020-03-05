package com.wnxy.hospital.mims.service.stock;

import java.util.List;

import com.wnxy.hospital.mims.entity.StMedicines;

public interface StMedicinesService {
	StMedicines selectById(String mid);
	List<StMedicines> selectAll();
}
