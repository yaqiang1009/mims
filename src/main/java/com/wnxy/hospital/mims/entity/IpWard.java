package com.wnxy.hospital.mims.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wnxy.hospital.mims.entity.AuthorityExample.Criteria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class IpWard {
    private String wardId;

    private String wardName;

    public String getWardId() {
        return wardId;
    }

    public void setWardId(String wardId) {
        this.wardId = wardId == null ? null : wardId.trim();
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName == null ? null : wardName.trim();
    }
}