package com.wnxy.hospital.mims.entity;

import java.util.Date;

public class OpRegistry {
    private String rsId;

    private String ptId;

    private String dlId;

    private Integer state;

    private Date date;

    public String getRsId() {
        return rsId;
    }

    public void setRsId(String rsId) {
        this.rsId = rsId == null ? null : rsId.trim();
    }

    public String getPtId() {
        return ptId;
    }

    public void setPtId(String ptId) {
        this.ptId = ptId == null ? null : ptId.trim();
    }

    public String getDlId() {
        return dlId;
    }

    public void setDlId(String dlId) {
        this.dlId = dlId == null ? null : dlId.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}