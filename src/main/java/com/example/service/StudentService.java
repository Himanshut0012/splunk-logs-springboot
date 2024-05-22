package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Student;

public interface StudentService {
	
	List<Student> getAllStudent();
	Optional<Student> getStudentById(Long id);
	Student saveStudent(Student student);
	String deleteStudent(Long id);
	Student updateStudent(Long id, Student student);
	

}
