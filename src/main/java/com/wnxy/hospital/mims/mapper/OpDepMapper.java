package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.OpDep;
import com.wnxy.hospital.mims.entity.OpDepExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpDepMapper {
    int countByExample(OpDepExample example);

    int deleteByExample(OpDepExample example);

    int deleteByPrimaryKey(String depId);

    int insert(OpDep record);

    int insertSelective(OpDep record);

    List<OpDep> selectByExample(OpDepExample example);

    OpDep selectByPrimaryKey(String depId);

    int updateByExampleSelective(@Param("record") OpDep record, @Param("example") OpDepExample example);

    int updateByExample(@Param("record") OpDep record, @Param("example") OpDepExample example);

    int updateByPrimaryKeySelective(OpDep record);

    int updateByPrimaryKey(OpDep record);
}