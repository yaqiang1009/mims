package com.wnxy.hospital.mims.service.ip;

import java.util.List;

import com.wnxy.hospital.mims.entity.IpIllness;
import com.wnxy.hospital.mims.entity.IpIllnessExample;
import com.wnxy.hospital.mims.entity.IpRemedy;

public interface Ip_IllnessService {
	String addIllnessOrder(IpIllness ipIllness);
	String updateIllnessOrder(IpIllness ipIllness);
	List<IpIllness> selectIpIllnessByExample(IpIllnessExample example);
}
