package com.wnxy.hospital.mims.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    private String stockId;

    private String medicineId;
    private StMedicines medicines;
    private String medicineDanwei;

    private Integer medicineNum;

    private String medicineType;

  
}