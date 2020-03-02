package com.wnxy.hospital.mims.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wnxy.hospital.mims.entity.AuthorityExample.Criteria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class IpBed {
    private String bedId;

    private String wardId;

    private Integer bedNum;

    public String getBedId() {
        return bedId;
    }

    public void setBedId(String bedId) {
        this.bedId = bedId == null ? null : bedId.trim();
    }

    public String getWardId() {
        return wardId;
    }

    public void setWardId(String wardId) {
        this.wardId = wardId == null ? null : wardId.trim();
    }

    public Integer getBedNum() {
        return bedNum;
    }

    public void setBedNum(Integer bedNum) {
        this.bedNum = bedNum;
    }


}