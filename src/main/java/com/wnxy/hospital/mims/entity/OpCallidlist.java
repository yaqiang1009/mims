package com.wnxy.hospital.mims.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpCallidlist {
	private String clId;

	private String rsId;

	private String empId;

	private Integer state;

	private Date date;

	public String getClId() {
		return clId;
	}

	public void setClId(String clId) {
		this.clId = clId == null ? null : clId.trim();
	}

	public String getRsId() {
		return rsId;
	}

	public void setRsId(String rsId) {
		this.rsId = rsId == null ? null : rsId.trim();
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId == null ? null : empId.trim();
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}