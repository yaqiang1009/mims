package com.wnxy.hospital.mims.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wnxy.hospital.mims.entity.PhMedicineInventory;
import com.wnxy.hospital.mims.entity.PhMedicineInventoryExample;

public interface PhMedicineInventoryMapper {
    int countByExample(PhMedicineInventoryExample example);

    int deleteByExample(PhMedicineInventoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(PhMedicineInventory record);

    int insertSelective(PhMedicineInventory record);

    List<PhMedicineInventory> selectByExample(PhMedicineInventoryExample example);

    PhMedicineInventory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PhMedicineInventory record, @Param("example") PhMedicineInventoryExample example);

    int updateByExample(@Param("record") PhMedicineInventory record, @Param("example") PhMedicineInventoryExample example);

    int updateByPrimaryKeySelective(PhMedicineInventory record);

    int updateByPrimaryKey(PhMedicineInventory record);
}