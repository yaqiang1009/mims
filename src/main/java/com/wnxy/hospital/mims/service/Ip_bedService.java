package com.wnxy.hospital.mims.service;

import java.util.List;

import com.wnxy.hospital.mims.entity.IpBed;

public interface Ip_bedService {
List<IpBed> selectBed(String wardId);
List<IpBed> selectWardAllBed(String wardId);
List<IpBed> selectAllBed();
List<IpBed> selectLeiAllBed();
void alterBed(String bedIdFor,String wardIdTo,int bedNum);
void createBed(String createWardId,int createBedNum);
}
