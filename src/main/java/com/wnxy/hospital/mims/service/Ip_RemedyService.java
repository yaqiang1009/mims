package com.wnxy.hospital.mims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.IpRemedy;

public interface Ip_RemedyService {
	PageInfo<IpRemedy> selectAllRemedy(String empId,int index);
	PageInfo<IpRemedy> selectAllRemedyPtName(String ptName);
	IpRemedy selectRemedy(String id);
	IpRemedy alertRemedy(String id,String bedId,String empId,String wardId);
	PageInfo<IpRemedy> selectHisAllRemedy(String ptName,int index);
}
