package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.OpTreatment;
import com.wnxy.hospital.mims.entity.OpTreatmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpTreatmentMapper {
    int countByExample(OpTreatmentExample example);

    int deleteByExample(OpTreatmentExample example);

    int deleteByPrimaryKey(String tmId);

    int insert(OpTreatment record);

    int insertSelective(OpTreatment record);

    List<OpTreatment> selectByExample(OpTreatmentExample example);

    OpTreatment selectByPrimaryKey(String tmId);

    int updateByExampleSelective(@Param("record") OpTreatment record, @Param("example") OpTreatmentExample example);

    int updateByExample(@Param("record") OpTreatment record, @Param("example") OpTreatmentExample example);

    int updateByPrimaryKeySelective(OpTreatment record);

    int updateByPrimaryKey(OpTreatment record);
}