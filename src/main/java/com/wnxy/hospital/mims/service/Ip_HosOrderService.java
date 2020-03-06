package com.wnxy.hospital.mims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.IpHospitalized;

public interface Ip_HosOrderService {
	PageInfo<IpHospitalized> selectAllHos(int index);
	IpHospitalized selectHos(String id);
	void updata(IpHospitalized hos);
	void overOrder(String id,String empId,String wardId,String bedId);
}
