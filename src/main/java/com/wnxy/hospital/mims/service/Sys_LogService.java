package com.wnxy.hospital.mims.service;

import java.util.Collection;

public interface Sys_LogService {
public String selectUser(String user);
public Collection<String> selectAuth(String user);
}
