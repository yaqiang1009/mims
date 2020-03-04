package com.wnxy.hospital.mims.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Damages {
    private String damageId;

    private Integer medicineCount;

    private String damageReason;

    private String medicineId;
    
    private PhMedicines phMedicines;

    private Integer status;

    private String source;

    public String getDamageId() {
        return damageId;
    }

    public void setDamageId(String damageId) {
        this.damageId = damageId == null ? null : damageId.trim();
    }

    public Integer getMedicineCount() {
        return medicineCount;
    }

    public void setMedicineCount(Integer medicineCount) {
        this.medicineCount = medicineCount;
    }

    public String getDamageReason() {
        return damageReason;
    }

    public void setDamageReason(String damageReason) {
        this.damageReason = damageReason == null ? null : damageReason.trim();
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId == null ? null : medicineId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }
}