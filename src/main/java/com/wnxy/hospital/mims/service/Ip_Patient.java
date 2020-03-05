package com.wnxy.hospital.mims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.OpPatientinfo;

public interface Ip_Patient {
PageInfo<OpPatientinfo> selectNowPatient(int index);
OpPatientinfo selectNowPtId(String id);
OpPatientinfo alterPt(String id,String phone,String familyperson,String familyphone,String address);
}
