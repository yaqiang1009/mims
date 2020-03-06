package com.wnxy.hospital.mims.service.op;

import java.util.List;

import com.wnxy.hospital.mims.entity.OpDruglist;

public interface DrugListService {
	
	void generateDrugList(List<OpDruglist> druglist);
	
	List<OpDruglist> getDrugList(String prescriptionid);
	
	void modifyDrugList(String druglistid, Integer num);
}
