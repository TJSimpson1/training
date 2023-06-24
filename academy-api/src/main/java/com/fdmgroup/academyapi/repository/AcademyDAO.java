package com.fdmgroup.academyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.academyapi.models.Academy;

public interface AcademyDAO extends JpaRepository<Academy, Integer> {

	Academy findByName(String name);
		
}
