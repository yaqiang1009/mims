package com.wnxy.hospital.mims.entity;

import java.util.Date;
import java.util.UUID;

import com.wnxy.hospital.mims.mapper.IpDrugMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IpIllness {
    private String illnessId=UUID.randomUUID().toString().trim().replaceAll("-", "");

    private String remedyId;
    private IpRemedy ipRemedy;

    private String illness;

    private String caution;

    private Date illnessDate;
    //药单
    private IpDrug ipDrug;
    public String getIllnessId() {
        return illnessId;
    }

    public void setIllnessId(String illnessId) {
        this.illnessId = illnessId == null ? null : illnessId.trim();
    }

    public String getRemedyId() {
        return remedyId;
    }

    public void setRemedyId(String remedyId) {
        this.remedyId = remedyId == null ? null : remedyId.trim();
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness == null ? null : illness.trim();
    }

    public String getCaution() {
        return caution;
    }

    public void setCaution(String caution) {
        this.caution = caution == null ? null : caution.trim();
    }

    public Date getIllnessDate() {
        return illnessDate;
    }

    public void setIllnessDate(Date illnessDate) {
        this.illnessDate = illnessDate;
    }
}