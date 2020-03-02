package com.wnxy.hospital.mims.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class EmpRole {
    private String erId;

    private String rolId;

    private String empId;

    public String getErId() {
        return erId;
    }

    public void setErId(String erId) {
        this.erId = erId == null ? null : erId.trim();
    }

    public String getRolId() {
        return rolId;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId == null ? null : rolId.trim();
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }
}