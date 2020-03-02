package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.PhMedicineClass;
import com.wnxy.hospital.mims.entity.PhMedicineClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhMedicineClassMapper {
    int countByExample(PhMedicineClassExample example);

    int deleteByExample(PhMedicineClassExample example);

    int deleteByPrimaryKey(String classId);

    int insert(PhMedicineClass record);

    int insertSelective(PhMedicineClass record);

    List<PhMedicineClass> selectByExample(PhMedicineClassExample example);

    PhMedicineClass selectByPrimaryKey(String classId);

    int updateByExampleSelective(@Param("record") PhMedicineClass record, @Param("example") PhMedicineClassExample example);

    int updateByExample(@Param("record") PhMedicineClass record, @Param("example") PhMedicineClassExample example);

    int updateByPrimaryKeySelective(PhMedicineClass record);

    int updateByPrimaryKey(PhMedicineClass record);
}