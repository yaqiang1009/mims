package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.OpRegistry;
import com.wnxy.hospital.mims.entity.OpRegistryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpRegistryMapper {
    int countByExample(OpRegistryExample example);

    int deleteByExample(OpRegistryExample example);

    int deleteByPrimaryKey(String rsId);

    int insert(OpRegistry record);

    int insertSelective(OpRegistry record);

    List<OpRegistry> selectByExample(OpRegistryExample example);

    OpRegistry selectByPrimaryKey(String rsId);

    int updateByExampleSelective(@Param("record") OpRegistry record, @Param("example") OpRegistryExample example);

    int updateByExample(@Param("record") OpRegistry record, @Param("example") OpRegistryExample example);

    int updateByPrimaryKeySelective(OpRegistry record);

    int updateByPrimaryKey(OpRegistry record);
}