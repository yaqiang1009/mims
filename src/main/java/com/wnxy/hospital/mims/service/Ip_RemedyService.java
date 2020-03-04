package com.wnxy.hospital.mims.service;

import java.util.List;

import com.wnxy.hospital.mims.entity.IpRemedy;

public interface Ip_RemedyService {
	List<IpRemedy> selectAllRemedy(String empId);
	IpRemedy selectRemedy(String id);
	IpRemedy alertRemedy(String id,String bedId,String empId,String wardId);
}
