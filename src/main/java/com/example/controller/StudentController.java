package com.example.controller;

import java.util.List;
import java.util.Optional;

import com.example.exception.StudentNotFoundException;
import com.example.model.Student;
import com.example.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

	private static final Logger LOGGER = LogManager.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student savedStudent = studentService.saveStudent(student);
		LOGGER.info("Saved student record: {}", savedStudent);
		return ResponseEntity.ok(savedStudent);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStudent(@PathVariable("id") Long id) {
		try {
			Optional<Student> student = studentService.getStudentById(id);
			LOGGER.info("Retrieved student record: {}", student);
			return ResponseEntity.ok(student.get());
		} catch (StudentNotFoundException e) {
			LOGGER.error("Student not found with id: {}", id, e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Error occurred while retrieving student with id: {}", id, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while retrieving the student");
		}
	}

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> students = studentService.getAllStudent();
		LOGGER.info("Retrieved all student records");
		return ResponseEntity.ok(students);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
		Student updatedStudent = studentService.updateStudent(id, student);
		LOGGER.info("Updated student record: {}", updatedStudent);
		return ResponseEntity.ok(updatedStudent);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
		try {
			String result = studentService.deleteStudent(id);
			LOGGER.info("Deleted student record with id: {}", id);
			return ResponseEntity.ok(result);
		} catch (StudentNotFoundException e) {
			LOGGER.error("Student not found with id: {}", id, e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Error occurred while deleting student with id: {}", id, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the student");
		}
	}

	@ExceptionHandler(StudentNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
}
