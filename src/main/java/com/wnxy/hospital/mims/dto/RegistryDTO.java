package com.wnxy.hospital.mims.dto;

import java.util.Date;

import com.wnxy.hospital.mims.entity.OpPatientinfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistryDTO {
	private String registryid;
	private OpPatientinfo patient;
	private DocterLevelDTO docterleveldto;
	private Integer state;
	private Date date;
	private Float registryprice;
	private EmpDTO doctor;
}
