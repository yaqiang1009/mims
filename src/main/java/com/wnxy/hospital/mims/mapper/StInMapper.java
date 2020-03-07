package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.StIn;
import com.wnxy.hospital.mims.entity.StInExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StInMapper {
    int countByExample(StInExample example);

    int deleteByExample(StInExample example);

    int deleteByPrimaryKey(String inId);

    int insert(StIn record);

    int insertSelective(StIn record);
    List<StIn> selectYueBaoBiao(String yue);

    List<StIn> selectByExample(StInExample example);

    StIn selectByPrimaryKey(String inId);

    int updateByExampleSelective(@Param("record") StIn record, @Param("example") StInExample example);

    int updateByExample(@Param("record") StIn record, @Param("example") StInExample example);

    int updateByPrimaryKeySelective(StIn record);

    int updateByPrimaryKey(StIn record);
}