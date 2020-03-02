package com.wnxy.hospital.mims.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class OpDoclevel {
    private String dlId;

    private String empId;

    private Integer level;

    private Float price;

    public String getDlId() {
        return dlId;
    }

    public void setDlId(String dlId) {
        this.dlId = dlId == null ? null : dlId.trim();
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}