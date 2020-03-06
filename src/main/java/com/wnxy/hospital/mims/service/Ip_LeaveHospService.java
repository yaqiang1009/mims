package com.wnxy.hospital.mims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wnxy.hospital.mims.entity.IpLeaveapply;

public interface Ip_LeaveHospService {
PageInfo<IpLeaveapply> selectAllLeave(int index);
void leavePass(String id);
IpLeaveapply selectLeave(String hosid);
void leaveReject(String id,String remarks);
}
