package com.wnxy.hospital.mims.service;

import java.util.List;

import com.wnxy.hospital.mims.entity.IpHospitalized;

public interface Ip_HosOrderService {
	List<IpHospitalized> selectAllHos();
}
