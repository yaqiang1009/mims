package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.StItem;
import com.wnxy.hospital.mims.entity.StItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StItemMapper {
    int countByExample(StItemExample example);

    int deleteByExample(StItemExample example);

    int deleteByPrimaryKey(String itemId);

    int insert(StItem record);

    int insertSelective(StItem record);

    List<StItem> selectByExample(StItemExample example);

    StItem selectByPrimaryKey(String itemId);

    int updateByExampleSelective(@Param("record") StItem record, @Param("example") StItemExample example);

    int updateByExample(@Param("record") StItem record, @Param("example") StItemExample example);

    int updateByPrimaryKeySelective(StItem record);

    int updateByPrimaryKey(StItem record);
}