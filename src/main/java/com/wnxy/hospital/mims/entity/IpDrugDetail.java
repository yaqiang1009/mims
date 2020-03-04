package com.wnxy.hospital.mims.entity;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IpDrugDetail {
    private String detailId=UUID.randomUUID().toString().trim().replaceAll("-", "");

    private String drugId;
    private IpDrug ipDrug;

    private String medicineId;
    private PhMedicines phMedicines;

    private Integer drugNum;

    private Double price;

    private String useInstructions;

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId == null ? null : detailId.trim();
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId == null ? null : drugId.trim();
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId == null ? null : medicineId.trim();
    }

    public Integer getDrugNum() {
        return drugNum;
    }

    public void setDrugNum(Integer drugNum) {
        this.drugNum = drugNum;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUseInstructions() {
        return useInstructions;
    }

    public void setUseInstructions(String useInstructions) {
        this.useInstructions = useInstructions == null ? null : useInstructions.trim();
    }
}