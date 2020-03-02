package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.PhMedicines;
import com.wnxy.hospital.mims.entity.PhMedicinesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhMedicinesMapper {
    int countByExample(PhMedicinesExample example);

    int deleteByExample(PhMedicinesExample example);

    int deleteByPrimaryKey(String medicineId);

    int insert(PhMedicines record);

    int insertSelective(PhMedicines record);

    List<PhMedicines> selectByExample(PhMedicinesExample example);

    PhMedicines selectByPrimaryKey(String medicineId);

    int updateByExampleSelective(@Param("record") PhMedicines record, @Param("example") PhMedicinesExample example);

    int updateByExample(@Param("record") PhMedicines record, @Param("example") PhMedicinesExample example);

    int updateByPrimaryKeySelective(PhMedicines record);

    int updateByPrimaryKey(PhMedicines record);
}