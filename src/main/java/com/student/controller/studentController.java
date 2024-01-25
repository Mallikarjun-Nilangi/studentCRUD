package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.dto.studentDto;
import com.student.services.studentServices;

@Controller
@RequestMapping("/student")
public class studentController {

	@Autowired
	private studentServices studentservice;
	
	@PostMapping
	public ResponseEntity<studentDto> createStudent(
		@RequestBody studentDto studentdto){
		
		 studentDto saveStudent= studentservice.saveStudent(studentdto);
		
		return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/{studentId}")
	public ResponseEntity<studentDto> updateStudent(
			     @PathVariable("studentId") Long id,
			     @RequestBody studentDto studentdto){
		studentDto updateStudent = studentservice.updateStudent(studentdto,id);
		return  new ResponseEntity<studentDto>(updateStudent, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") Long id){
		
		studentservice.deleteStudent(id);
		
		return new ResponseEntity<String>("student Deleted Successfully !!", HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<studentDto>> getAllStudents(){
		List<studentDto> allStudents = studentservice.getAllStudents();
		
		return new ResponseEntity<>(allStudents,HttpStatus.OK);
	}
}
