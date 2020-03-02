package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.OpOptioncharge;
import com.wnxy.hospital.mims.entity.OpOptionchargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpOptionchargeMapper {
    int countByExample(OpOptionchargeExample example);

    int deleteByExample(OpOptionchargeExample example);

    int deleteByPrimaryKey(String ocId);

    int insert(OpOptioncharge record);

    int insertSelective(OpOptioncharge record);

    List<OpOptioncharge> selectByExample(OpOptionchargeExample example);

    OpOptioncharge selectByPrimaryKey(String ocId);

    int updateByExampleSelective(@Param("record") OpOptioncharge record, @Param("example") OpOptionchargeExample example);

    int updateByExample(@Param("record") OpOptioncharge record, @Param("example") OpOptionchargeExample example);

    int updateByPrimaryKeySelective(OpOptioncharge record);

    int updateByPrimaryKey(OpOptioncharge record);
}