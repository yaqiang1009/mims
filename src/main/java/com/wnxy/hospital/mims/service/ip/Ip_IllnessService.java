package com.wnxy.hospital.mims.service.ip;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.IpIllness;
import com.wnxy.hospital.mims.entity.IpIllnessExample;
import com.wnxy.hospital.mims.entity.IpRemedy;

public interface Ip_IllnessService {
	String addIllnessOrder(IpIllness ipIllness,String remedyId);
	String updateIllnessOrder(IpIllness ipIllness);
	PageInfo<IpIllness> selectAllIpIllnessByRemedyId(String remedyId,int index);
	IpIllness selectIpIllnessById(String illnessId);
	IpIllness selectNewIllnessByRemedyId(String remedyId);
}
