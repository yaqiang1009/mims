package com.wnxy.hospital.mims.service.ip;

import java.util.List;

import com.wnxy.hospital.mims.entity.IpDrugDetail;

public interface Ip_DrugDetailService {
	String addDrugDetailOrder(List<IpDrugDetail> ipDrugDetails,String drugId);
	List<IpDrugDetail> selectAllDrugDetailsByDrugId(String drugId);
	//Double getPriceTotal(String drugId);
}
