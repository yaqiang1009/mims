package com.wnxy.hospital.mims.entity;

import java.util.Date;

public class IpHospitalized {
    private String hospitalizedId;

    private String ptId;

    private String empId;

    private String illness;

    private String order;

    private String remarks;

    private Date orderDate;

    public String getHospitalizedId() {
        return hospitalizedId;
    }

    public void setHospitalizedId(String hospitalizedId) {
        this.hospitalizedId = hospitalizedId == null ? null : hospitalizedId.trim();
    }

    public String getPtId() {
        return ptId;
    }

    public void setPtId(String ptId) {
        this.ptId = ptId == null ? null : ptId.trim();
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness == null ? null : illness.trim();
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order == null ? null : order.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}