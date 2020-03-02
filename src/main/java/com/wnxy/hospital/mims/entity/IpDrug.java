package com.wnxy.hospital.mims.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Component
public class IpDrug {
    private String drugId;

    private String illnessId;

    private Double totalPrice;

    private String drugStatus;

    private Date drugDate;

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId == null ? null : drugId.trim();
    }

    public String getIllnessId() {
        return illnessId;
    }

    public void setIllnessId(String illnessId) {
        this.illnessId = illnessId == null ? null : illnessId.trim();
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDrugStatus() {
        return drugStatus;
    }

    public void setDrugStatus(String drugStatus) {
        this.drugStatus = drugStatus == null ? null : drugStatus.trim();
    }

    public Date getDrugDate() {
        return drugDate;
    }

    public void setDrugDate(Date drugDate) {
        this.drugDate = drugDate;
    }
}