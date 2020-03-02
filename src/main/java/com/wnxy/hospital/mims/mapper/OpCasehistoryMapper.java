package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.OpCasehistory;
import com.wnxy.hospital.mims.entity.OpCasehistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpCasehistoryMapper {
    int countByExample(OpCasehistoryExample example);

    int deleteByExample(OpCasehistoryExample example);

    int deleteByPrimaryKey(String caseId);

    int insert(OpCasehistory record);

    int insertSelective(OpCasehistory record);

    List<OpCasehistory> selectByExample(OpCasehistoryExample example);

    OpCasehistory selectByPrimaryKey(String caseId);

    int updateByExampleSelective(@Param("record") OpCasehistory record, @Param("example") OpCasehistoryExample example);

    int updateByExample(@Param("record") OpCasehistory record, @Param("example") OpCasehistoryExample example);

    int updateByPrimaryKeySelective(OpCasehistory record);

    int updateByPrimaryKey(OpCasehistory record);
}