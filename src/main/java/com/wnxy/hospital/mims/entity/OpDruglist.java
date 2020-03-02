package com.wnxy.hospital.mims.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class OpDruglist {
    private String dlId;

    private String ptId;

    private String medicineId;

    private Integer num;

    private Float singleprice;

    public String getDlId() {
        return dlId;
    }

    public void setDlId(String dlId) {
        this.dlId = dlId == null ? null : dlId.trim();
    }

    public String getPtId() {
        return ptId;
    }

    public void setPtId(String ptId) {
        this.ptId = ptId == null ? null : ptId.trim();
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId == null ? null : medicineId.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Float getSingleprice() {
        return singleprice;
    }

    public void setSingleprice(Float singleprice) {
        this.singleprice = singleprice;
    }
}