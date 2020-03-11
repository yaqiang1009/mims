package com.wnxy.hospital.mims.dto;

import java.util.Date;

import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.entity.OpTreatment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaseHistoryDTO {

	private String casehistoryid;
	
	private OpPatientinfo patientinfo;
	
	private OpTreatment treatment;
	
	private String description;
	
	private Date date;
	
	private Integer state;
}
