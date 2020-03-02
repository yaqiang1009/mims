package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.PhDispatch;
import com.wnxy.hospital.mims.entity.PhDispatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhDispatchMapper {
    int countByExample(PhDispatchExample example);

    int deleteByExample(PhDispatchExample example);

    int deleteByPrimaryKey(String dispatchId);

    int insert(PhDispatch record);

    int insertSelective(PhDispatch record);

    List<PhDispatch> selectByExample(PhDispatchExample example);

    PhDispatch selectByPrimaryKey(String dispatchId);

    int updateByExampleSelective(@Param("record") PhDispatch record, @Param("example") PhDispatchExample example);

    int updateByExample(@Param("record") PhDispatch record, @Param("example") PhDispatchExample example);

    int updateByPrimaryKeySelective(PhDispatch record);

    int updateByPrimaryKey(PhDispatch record);
}