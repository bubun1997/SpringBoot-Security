package com.soumya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soumya.entity.Student;
import com.soumya.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) { this.studentService = studentService; }
	
	
	@PostMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(student));
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
		
		return ResponseEntity.ok(studentService.getAllStudents());
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('USER')")
	public ResponseEntity<Student> findStudentById(@PathVariable Long id){
		
		return ResponseEntity.ok(studentService.getStudentById(id));
		
	}

}
