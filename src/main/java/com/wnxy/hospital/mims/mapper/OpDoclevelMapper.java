package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.OpDoclevel;
import com.wnxy.hospital.mims.entity.OpDoclevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpDoclevelMapper {
    int countByExample(OpDoclevelExample example);

    int deleteByExample(OpDoclevelExample example);

    int deleteByPrimaryKey(String dlId);

    int insert(OpDoclevel record);

    int insertSelective(OpDoclevel record);

    List<OpDoclevel> selectByExample(OpDoclevelExample example);

    OpDoclevel selectByPrimaryKey(String dlId);

    int updateByExampleSelective(@Param("record") OpDoclevel record, @Param("example") OpDoclevelExample example);

    int updateByExample(@Param("record") OpDoclevel record, @Param("example") OpDoclevelExample example);

    int updateByPrimaryKeySelective(OpDoclevel record);

    int updateByPrimaryKey(OpDoclevel record);
}