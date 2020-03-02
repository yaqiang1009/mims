package com.wnxy.hospital.mims.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IpCashUse {
    private String cashUseId;

    private String cashId;

    private Date cashUseDate;

    private String illnessId;

    private Double useCash;

    public String getCashUseId() {
        return cashUseId;
    }

    public void setCashUseId(String cashUseId) {
        this.cashUseId = cashUseId == null ? null : cashUseId.trim();
    }

    public String getCashId() {
        return cashId;
    }

    public void setCashId(String cashId) {
        this.cashId = cashId == null ? null : cashId.trim();
    }

    public Date getCashUseDate() {
        return cashUseDate;
    }

    public void setCashUseDate(Date cashUseDate) {
        this.cashUseDate = cashUseDate;
    }

    public String getIllnessId() {
        return illnessId;
    }

    public void setIllnessId(String illnessId) {
        this.illnessId = illnessId == null ? null : illnessId.trim();
    }

    public Double getUseCash() {
        return useCash;
    }

    public void setUseCash(Double useCash) {
        this.useCash = useCash;
    }
}