package com.wnxy.hospital.mims.service;

import java.util.List;

import com.wnxy.hospital.mims.entity.OpPatientinfo;

public interface Ip_Patient {
List<OpPatientinfo> selectNowPatient();
OpPatientinfo selectNowPtId(String id);
OpPatientinfo alterPt(String id,String phone,String familyperson,String familyphone,String address);
}
