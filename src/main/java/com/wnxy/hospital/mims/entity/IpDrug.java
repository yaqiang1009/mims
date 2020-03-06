package com.wnxy.hospital.mims.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IpDrug {
    private String drugId=UUID.randomUUID().toString().trim().replaceAll("-", "");

    private String illnessId;
    private IpIllness ipIllness;

    private Double totalPrice;

    private String drugStatus;

    private Date drugDate;
    //药单明细
    private List<IpDrugDetail> ipDrugDetails;
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