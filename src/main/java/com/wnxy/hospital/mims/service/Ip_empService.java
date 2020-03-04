package com.wnxy.hospital.mims.service;

import java.util.List;

import com.wnxy.hospital.mims.entity.Emp;

public interface Ip_empService {
List<Emp> selectAllEmp();
Emp selectEmp(String id);
}
