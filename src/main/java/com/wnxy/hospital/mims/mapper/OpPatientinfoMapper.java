package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.entity.OpPatientinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpPatientinfoMapper {
    int countByExample(OpPatientinfoExample example);

    int deleteByExample(OpPatientinfoExample example);

    int deleteByPrimaryKey(String ptId);

    int insert(OpPatientinfo record);

    int insertSelective(OpPatientinfo record);

    List<OpPatientinfo> selectByExample(OpPatientinfoExample example);

    OpPatientinfo selectByPrimaryKey(String ptId);

    int updateByExampleSelective(@Param("record") OpPatientinfo record, @Param("example") OpPatientinfoExample example);

    int updateByExample(@Param("record") OpPatientinfo record, @Param("example") OpPatientinfoExample example);

    int updateByPrimaryKeySelective(OpPatientinfo record);

    int updateByPrimaryKey(OpPatientinfo record);
}