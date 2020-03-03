package com.wnxy.hospital.mims.service;

import java.util.List;

import com.wnxy.hospital.mims.entity.IpLeaveapply;

public interface leavehospService {
List<IpLeaveapply> selectAllLeave();
void leavePass(String id);
}
