package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.OpCard;
import com.wnxy.hospital.mims.entity.OpCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpCardMapper {
    int countByExample(OpCardExample example);

    int deleteByExample(OpCardExample example);

    int deleteByPrimaryKey(String cardId);

    int insert(OpCard record);

    int insertSelective(OpCard record);

    List<OpCard> selectByExample(OpCardExample example);

    OpCard selectByPrimaryKey(String cardId);

    int updateByExampleSelective(@Param("record") OpCard record, @Param("example") OpCardExample example);

    int updateByExample(@Param("record") OpCard record, @Param("example") OpCardExample example);

    int updateByPrimaryKeySelective(OpCard record);

    int updateByPrimaryKey(OpCard record);
}