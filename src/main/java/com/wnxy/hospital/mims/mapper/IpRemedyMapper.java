package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.IpRemedy;
import com.wnxy.hospital.mims.entity.IpRemedyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IpRemedyMapper {
    int countByExample(IpRemedyExample example);

    int deleteByExample(IpRemedyExample example);

    int deleteByPrimaryKey(String remedyId);

    int insert(IpRemedy record);

    int insertSelective(IpRemedy record);

    List<IpRemedy> selectByExample(IpRemedyExample example);

    IpRemedy selectByPrimaryKey(String remedyId);

    int updateByExampleSelective(@Param("record") IpRemedy record, @Param("example") IpRemedyExample example);

    int updateByExample(@Param("record") IpRemedy record, @Param("example") IpRemedyExample example);

    int updateByPrimaryKeySelective(IpRemedy record);

    int updateByPrimaryKey(IpRemedy record);
}