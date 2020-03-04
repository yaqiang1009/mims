package com.wnxy.hospital.mims.service.ip;

import java.util.List;

import com.wnxy.hospital.mims.entity.IpIllness;
import com.wnxy.hospital.mims.entity.IpIllnessExample;
import com.wnxy.hospital.mims.entity.IpRemedy;

public interface Ip_IllnessService {
	String addIllnessOrder(IpIllness ipIllness,String remedyId);
	String updateIllnessOrder(IpIllness ipIllness);
	List<IpIllness> selectAllIpIllnessByRemedyId(String remedyId);
	IpIllness selectIpIllnessById(String illnessId);
}
