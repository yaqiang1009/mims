package com.wnxy.hospital.mims.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CallIdItemDTO {
	
	private String callistid;
	
	private RegistryDTO registrydto;
	
	private EmpDTO doctor;
	
	private Date date;
	
	private Integer state;
}
