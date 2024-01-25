package com.student.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dto.studentDto;
import com.student.entities.student;
import com.student.repositories.studentRepository;

@Service
public class studentServiceImpl implements studentServices {

	@Autowired
	private studentRepository studentRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public studentDto saveStudent(studentDto studentdto) {
		student student = DtoToEntity(studentdto);
		
	   student saveStudent= studentRepo.save(student);
	   
	   studentDto savesDto = EntityToDto(saveStudent);
	   
		return savesDto;
	}
	
	
	@Override
	public studentDto updateStudent(studentDto studentdto, Long id) {
		Optional<student> st = studentRepo.findById(id);
		student student = st.get();
		student.setFirstName(studentdto.getFirstName());
		student.setLastName(studentdto.getLastName());
		student.setEmail(studentdto.getEmail());
		student.setCity(studentdto.getCity());
		
		student savesStd = studentRepo.save(student);
		
		studentDto savedDto = EntityToDto(savesStd);
		
		return savedDto;
	}
	
	
	@Override
	public studentDto deleteStudent(Long id) {
		
		Optional<student> st = studentRepo.findById(id);
		student student = st.get();
		studentRepo.delete(student);
		return null;
	}


	@Override
	public List<studentDto> getAllStudents() {
	     
		List<student> students = studentRepo.findAll();
		 List<studentDto> dtolist = students.stream().map(student -> EntityToDto(student)).collect(Collectors.toList());
		 
		return dtolist;
	}
	

	private studentDto EntityToDto(student saveStudent) {
		return mapper.map(saveStudent, studentDto.class);
	}
	
	private student DtoToEntity(studentDto studentdto) {
		
		return mapper.map(studentdto, student.class);
	}


	


	




	
}
