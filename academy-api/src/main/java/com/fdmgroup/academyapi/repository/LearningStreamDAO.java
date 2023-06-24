package com.fdmgroup.academyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.academyapi.models.Stream;

public interface LearningStreamDAO extends JpaRepository<Stream, Integer> {

	Stream findByName(String name);
	
}
