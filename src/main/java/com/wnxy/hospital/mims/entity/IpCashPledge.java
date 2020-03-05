package com.wnxy.hospital.mims.entity;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IpCashPledge {
    private String cashId=UUID.randomUUID().toString().trim().replaceAll("-", "");

    private String ptId;
    private OpPatientinfo opPatientinfo;

    private Double remaining;

    public String getCashId() {
        return cashId;
    }

    public void setCashId(String cashId) {
        this.cashId = cashId == null ? null : cashId.trim();
    }

    public String getPtId() {
        return ptId;
    }

    public void setPtId(String ptId) {
        this.ptId = ptId == null ? null : ptId.trim();
    }

    public Double getRemaining() {
        return remaining;
    }

    public void setRemaining(Double remaining) {
        this.remaining = remaining;
    }
}