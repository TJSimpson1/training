package com.fdmgroup.academyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.academyapi.models.Course;

public interface CourseDAO extends JpaRepository<Course, Integer> {

	Course findByName(String name);
}
