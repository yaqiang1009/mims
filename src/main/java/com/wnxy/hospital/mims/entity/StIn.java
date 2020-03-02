package com.wnxy.hospital.mims.entity;

import java.util.Date;

public class StIn {
    private String inId;

    private String supplierId;

    private String itemId;

    private Date time;

    public String getInId() {
        return inId;
    }

    public void setInId(String inId) {
        this.inId = inId == null ? null : inId.trim();
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}