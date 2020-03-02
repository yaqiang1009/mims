package com.wnxy.hospital.mims.entity;

public class UserAuthority {
    private String uaId;

    private String authorityId;

    private String rolId;

    public String getUaId() {
        return uaId;
    }

    public void setUaId(String uaId) {
        this.uaId = uaId == null ? null : uaId.trim();
    }

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId == null ? null : authorityId.trim();
    }

    public String getRolId() {
        return rolId;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId == null ? null : rolId.trim();
    }
}