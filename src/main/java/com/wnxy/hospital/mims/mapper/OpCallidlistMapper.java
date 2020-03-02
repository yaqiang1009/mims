package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.OpCallidlist;
import com.wnxy.hospital.mims.entity.OpCallidlistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpCallidlistMapper {
    int countByExample(OpCallidlistExample example);

    int deleteByExample(OpCallidlistExample example);

    int deleteByPrimaryKey(String clId);

    int insert(OpCallidlist record);

    int insertSelective(OpCallidlist record);

    List<OpCallidlist> selectByExample(OpCallidlistExample example);

    OpCallidlist selectByPrimaryKey(String clId);

    int updateByExampleSelective(@Param("record") OpCallidlist record, @Param("example") OpCallidlistExample example);

    int updateByExample(@Param("record") OpCallidlist record, @Param("example") OpCallidlistExample example);

    int updateByPrimaryKeySelective(OpCallidlist record);

    int updateByPrimaryKey(OpCallidlist record);
}