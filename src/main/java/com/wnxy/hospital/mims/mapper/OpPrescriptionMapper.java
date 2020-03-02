package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.OpPrescription;
import com.wnxy.hospital.mims.entity.OpPrescriptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpPrescriptionMapper {
    int countByExample(OpPrescriptionExample example);

    int deleteByExample(OpPrescriptionExample example);

    int deleteByPrimaryKey(String ptId);

    int insert(OpPrescription record);

    int insertSelective(OpPrescription record);

    List<OpPrescription> selectByExample(OpPrescriptionExample example);

    OpPrescription selectByPrimaryKey(String ptId);

    int updateByExampleSelective(@Param("record") OpPrescription record, @Param("example") OpPrescriptionExample example);

    int updateByExample(@Param("record") OpPrescription record, @Param("example") OpPrescriptionExample example);

    int updateByPrimaryKeySelective(OpPrescription record);

    int updateByPrimaryKey(OpPrescription record);
}