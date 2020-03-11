package com.wnxy.hospital.mims.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocterLevelDTO {

	private String doctorlevelid;
	
	private EmpDTO doctor;
	
	private Integer level;
	
	private Float price;
}
