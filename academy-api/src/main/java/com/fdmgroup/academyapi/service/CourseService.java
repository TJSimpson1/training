package com.fdmgroup.academyapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.academyapi.models.Course;
import com.fdmgroup.academyapi.repository.CourseDAO;

@Service
public class CourseService {

	@Autowired
	private CourseDAO courseDAO;
	
	
	public List<Course> getAllCourses(){
		return courseDAO.findAll();	
	}
	
	public Course createCourse(Course course) {
		Course existingCourse = courseDAO.findByName(course.getName());
		if (existingCourse == null) {
			return courseDAO.save(course);
		}
		return null;
	}
	
	public Course getCourse(int courseId) {
		Optional<Course> course = courseDAO.findById(courseId);
		
		if (course.isPresent()) {
			return course.get();
		}
		return null;
	}
	
	public boolean updateCourse(Course course) {
		if (courseDAO.existsById(course.getId())) {
			courseDAO.save(course);
			return true;
		}
		return false;
	}
	
	public boolean removeCourse(int courseId) {
		if (courseDAO.existsById(courseId)) {
			courseDAO.deleteById(courseId);
			return true;
		}
		return false;
	}
	
}
