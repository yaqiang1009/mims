package com.wnxy.hospital.mims.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IpRemedy {
    private String remedyId;

    private String hospitalizedId;
    private IpHospitalized ipHospitalized;
    
    private String wardId;
    private IpWard ipWard;

    private String bedId;
    private IpBed ipBed;

    private String ptId;
    private OpPatientinfo opPatientinfo;

    private String empId;
    private Emp emp;

    private Date remedyDate;

    private String remedyStatus;

    public String getRemedyId() {
        return remedyId;
    }

    public void setRemedyId(String remedyId) {
        this.remedyId = remedyId == null ? null : remedyId.trim();
    }

    public String getHospitalizedId() {
        return hospitalizedId;
    }

    public void setHospitalizedId(String hospitalizedId) {
        this.hospitalizedId = hospitalizedId == null ? null : hospitalizedId.trim();
    }

    public String getWardId() {
        return wardId;
    }

    public void setWardId(String wardId) {
        this.wardId = wardId == null ? null : wardId.trim();
    }

    public String getBedId() {
        return bedId;
    }

    public void setBedId(String bedId) {
        this.bedId = bedId == null ? null : bedId.trim();
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

    public Date getRemedyDate() {
        return remedyDate;
    }

    public void setRemedyDate(Date remedyDate) {
        this.remedyDate = remedyDate;
    }

    public String getRemedyStatus() {
        return remedyStatus;
    }

    public void setRemedyStatus(String remedyStatus) {
        this.remedyStatus = remedyStatus == null ? null : remedyStatus.trim();
    }
}