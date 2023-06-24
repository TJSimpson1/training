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
import com.fdmgroup.academyapi.service.CourseService;

@RestController
@RequestMapping("/api/v1/course")
@CrossOrigin(origins="http://localhost:3000")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public List<Course> getCourses(){
		return courseService.getAllCourses();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable int id){	
		Course course = courseService.getCourse(id);
		
		if (course != null) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(course);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable int id){
		if (courseService.removeCourse(id)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping
	public ResponseEntity<Course> createCourse(@RequestBody Course course){
		Course createdCourse = courseService.createCourse(course);
		
		if (createdCourse != null) {
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{CourseId}")
					.buildAndExpand(createdCourse.getId())
					.toUri();
			return ResponseEntity
					.created(location)
					.build();
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@PutMapping
	public ResponseEntity<Course> updateBook(@RequestBody Course Course) {
		
		if (courseService.updateCourse(Course)) {
			return ResponseEntity.ok(Course);
		} 
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
