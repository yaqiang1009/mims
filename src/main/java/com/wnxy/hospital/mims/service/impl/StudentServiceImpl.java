package com.wnxy.hospital.mims.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wnxy.hospital.mims.entity.Student;
import com.wnxy.hospital.mims.mapper.StudentMapper;
import com.wnxy.hospital.mims.service.StudentService;

@Component
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentMapper studentMapper;

	@Override
	public void addStu(Student student) {
		
		studentMapper.addstudent(student);
		
	}
}
