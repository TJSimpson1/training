package com.fdmgroup.academyapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.academyapi.models.Course;
import com.fdmgroup.academyapi.models.ExamResult;
import com.fdmgroup.academyapi.models.Trainee;
import com.fdmgroup.academyapi.service.ExamResultService;

@RestController
@RequestMapping("/api/v1/examResult")
@CrossOrigin(origins="http://localhost:3000")
public class ExamResultController {

	@Autowired
	private ExamResultService examResultService;
	
	@GetMapping
	public List<ExamResult> getAllExamResults(){
		return examResultService.getAllExamResults();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ExamResult> getExamResult(@PathVariable int id){	
		ExamResult examResult = examResultService.getExamResult(id);
		
		if (examResult != null) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(examResult);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteExamResult(@PathVariable int id){
		if (examResultService.removeExamResult(id)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping
	public ResponseEntity<ExamResult> createexamResult(@RequestBody ExamResult examResult){
		ExamResult createdExamResult = examResultService.createExamResult(examResult);
		
		if (createdExamResult != null) {
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{examResultId}")
					.buildAndExpand(createdExamResult.getId())
					.toUri();
			return ResponseEntity
					.created(location)
					.build();
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@PutMapping
	public ResponseEntity<ExamResult> updateBook(@RequestBody ExamResult examResult) {
		
		if (examResultService.updateExamResult(examResult)) {
			return ResponseEntity.ok(examResult);
		} 
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("course")
	public List<ExamResult> getAllExamResultsByCourse(@RequestBody Course course){	
		return examResultService.getExamResultsByCourse(course);
	}
	
	@GetMapping("trainee")
	public List<ExamResult> getAllExamResultsByTrainee(@RequestBody Trainee trainee){	
		System.out.println("in controller, trainee is "+trainee.getName());
		return examResultService.getExamResultsByTrainee(trainee);
	}
	
	@GetMapping("trainee/{id}")
	public List<ExamResult> getAllExamResultsByTraineeId(@PathVariable("id") int traineeId){
		return examResultService.getExamResultsByTraineeId(traineeId);
	}
	
}
