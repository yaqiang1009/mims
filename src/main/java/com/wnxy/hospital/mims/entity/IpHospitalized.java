package com.wnxy.hospital.mims.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IpHospitalized {
    private String hospitalizedId;
    
    private String ptId;
    private OpPatientinfo ptentity;
    
    private String empId;
    private Emp empentity;
    
    private String illness;

    private String hosOrder;

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

    public String getHosOrder() {
        return hosOrder;
    }

    public void setHosOrder(String hosOrder) {
        this.hosOrder = hosOrder == null ? null : hosOrder.trim();
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