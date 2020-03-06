package com.wnxy.hospital.mims.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.IpDrug;
import com.wnxy.hospital.mims.entity.IpIllness;
import com.wnxy.hospital.mims.entity.IpRemedy;

public interface Ip_DrService {
	PageInfo<IpDrug> selectNowAllDr(int index);
	PageInfo<IpIllness> selectIpIllnesss(String id,int index);
}
