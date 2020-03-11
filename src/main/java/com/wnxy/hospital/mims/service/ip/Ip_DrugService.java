package com.wnxy.hospital.mims.service.ip;

import com.wnxy.hospital.mims.entity.IpDrug;

public interface Ip_DrugService {
	String addDrugOrder(IpDrug ipDrug,String illnessId);
	//String updateDrugTotalPriceTotal(String drugId,Double totalPrice);
	String deleteDrugStatus(IpDrug ipDrug);
	//String updateDrugStatusWithPrice(IpDrug ipDrug,int result);
	IpDrug selectDrugByDrugId(String drugId);
	IpDrug selectDrugByIllnessId(String illnessId);
}
