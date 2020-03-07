package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.StOut;
import com.wnxy.hospital.mims.entity.StOutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StOutMapper {
    int countByExample(StOutExample example);

    int deleteByExample(StOutExample example);

    int deleteByPrimaryKey(String outId);
    
    int insert(StOut record);

    int insertSelective(StOut record);
    List<StOut> selectYueBaoBiao(String yue);
    List<StOut> selectByExample(StOutExample example);

    StOut selectByPrimaryKey(String outId);

    int updateByExampleSelective(@Param("record") StOut record, @Param("example") StOutExample example);

    int updateByExample(@Param("record") StOut record, @Param("example") StOutExample example);

    int updateByPrimaryKeySelective(StOut record);

    int updateByPrimaryKey(StOut record);
}