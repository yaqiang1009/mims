package com.wnxy.hospital.mims.entity;

public class OpOptionchargestandard {
    private String ocName;

    private Float singleprice;

    public String getOcName() {
        return ocName;
    }

    public void setOcName(String ocName) {
        this.ocName = ocName == null ? null : ocName.trim();
    }

    public Float getSingleprice() {
        return singleprice;
    }

    public void setSingleprice(Float singleprice) {
        this.singleprice = singleprice;
    }
}