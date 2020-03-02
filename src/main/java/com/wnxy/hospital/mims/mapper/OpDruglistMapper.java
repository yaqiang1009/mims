package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.OpDruglist;
import com.wnxy.hospital.mims.entity.OpDruglistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpDruglistMapper {
    int countByExample(OpDruglistExample example);

    int deleteByExample(OpDruglistExample example);

    int deleteByPrimaryKey(String dlId);

    int insert(OpDruglist record);

    int insertSelective(OpDruglist record);

    List<OpDruglist> selectByExample(OpDruglistExample example);

    OpDruglist selectByPrimaryKey(String dlId);

    int updateByExampleSelective(@Param("record") OpDruglist record, @Param("example") OpDruglistExample example);

    int updateByExample(@Param("record") OpDruglist record, @Param("example") OpDruglistExample example);

    int updateByPrimaryKeySelective(OpDruglist record);

    int updateByPrimaryKey(OpDruglist record);
}