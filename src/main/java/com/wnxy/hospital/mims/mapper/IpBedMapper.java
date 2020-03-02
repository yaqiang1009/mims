package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.IpBed;
import com.wnxy.hospital.mims.entity.IpBedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IpBedMapper {
    int countByExample(IpBedExample example);

    int deleteByExample(IpBedExample example);

    int deleteByPrimaryKey(String bedId);

    int insert(IpBed record);

    int insertSelective(IpBed record);

    List<IpBed> selectByExample(IpBedExample example);

    IpBed selectByPrimaryKey(String bedId);

    int updateByExampleSelective(@Param("record") IpBed record, @Param("example") IpBedExample example);

    int updateByExample(@Param("record") IpBed record, @Param("example") IpBedExample example);

    int updateByPrimaryKeySelective(IpBed record);

    int updateByPrimaryKey(IpBed record);
}