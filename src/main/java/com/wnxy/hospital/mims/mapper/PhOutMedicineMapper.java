package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.PhOutMedicine;
import com.wnxy.hospital.mims.entity.PhOutMedicineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhOutMedicineMapper {
    int countByExample(PhOutMedicineExample example);

    int deleteByExample(PhOutMedicineExample example);

    int deleteByPrimaryKey(String outId);

    int insert(PhOutMedicine record);

    int insertSelective(PhOutMedicine record);

    List<PhOutMedicine> selectByExample(PhOutMedicineExample example);

    PhOutMedicine selectByPrimaryKey(String outId);

    int updateByExampleSelective(@Param("record") PhOutMedicine record, @Param("example") PhOutMedicineExample example);

    int updateByExample(@Param("record") PhOutMedicine record, @Param("example") PhOutMedicineExample example);

    int updateByPrimaryKeySelective(PhOutMedicine record);

    int updateByPrimaryKey(PhOutMedicine record);
}