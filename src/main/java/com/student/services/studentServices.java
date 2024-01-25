package com.student.services;

import java.util.List;

import com.student.dto.studentDto;

public interface studentServices {

	public studentDto saveStudent(studentDto studentdto);

	public  studentDto updateStudent(studentDto studentdto, Long id);

	public studentDto deleteStudent(Long id);

	public List<studentDto> getAllStudents();
		
}
