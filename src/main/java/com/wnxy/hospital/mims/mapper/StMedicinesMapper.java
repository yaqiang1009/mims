package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.StMedicines;
import com.wnxy.hospital.mims.entity.StMedicinesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StMedicinesMapper {
    int countByExample(StMedicinesExample example);

    int deleteByExample(StMedicinesExample example);

    int deleteByPrimaryKey(String medicineId);

    int insert(StMedicines record);

    int insertSelective(StMedicines record);

    List<StMedicines> selectByExample(StMedicinesExample example);

    StMedicines selectByPrimaryKey(String medicineId);

    int updateByExampleSelective(@Param("record") StMedicines record, @Param("example") StMedicinesExample example);

    int updateByExample(@Param("record") StMedicines record, @Param("example") StMedicinesExample example);

    int updateByPrimaryKeySelective(StMedicines record);

    int updateByPrimaryKey(StMedicines record);
}