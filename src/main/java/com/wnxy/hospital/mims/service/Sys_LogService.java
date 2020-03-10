package com.wnxy.hospital.mims.service;

import java.util.Collection;

import com.wnxy.hospital.mims.entity.UserPsd;

public interface Sys_LogService {
public UserPsd selectUser(String user);
public Collection<String> selectAuth(String user);
}
