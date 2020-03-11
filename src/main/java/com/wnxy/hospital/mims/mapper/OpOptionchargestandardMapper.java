package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.OpOptionchargestandard;
import com.wnxy.hospital.mims.entity.OpOptionchargestandardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpOptionchargestandardMapper {
    int countByExample(OpOptionchargestandardExample example);

    int deleteByExample(OpOptionchargestandardExample example);

    int deleteByPrimaryKey(String ocName);

    int insert(OpOptionchargestandard record);

    int insertSelective(OpOptionchargestandard record);

    List<OpOptionchargestandard> selectByExample(OpOptionchargestandardExample example);

    OpOptionchargestandard selectByPrimaryKey(String ocName);

    int updateByExampleSelective(@Param("record") OpOptionchargestandard record, @Param("example") OpOptionchargestandardExample example);

    int updateByExample(@Param("record") OpOptionchargestandard record, @Param("example") OpOptionchargestandardExample example);

    int updateByPrimaryKeySelective(OpOptionchargestandard record);

    int updateByPrimaryKey(OpOptionchargestandard record);
}