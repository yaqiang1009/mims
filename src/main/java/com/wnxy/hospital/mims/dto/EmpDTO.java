package com.wnxy.hospital.mims.dto;

import java.util.Date;

import com.wnxy.hospital.mims.entity.Office;
import com.wnxy.hospital.mims.entity.OpDep;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpDTO {
	private String empid;
	private Office office;
	private OpDep dep;
	private String empname;
	private String identity;
	private String sex;
	private String address;
	private String email;
	private Date birthday;
	private String nation;
	private Date hireday;
	private String photo;
	private String phone;
}
