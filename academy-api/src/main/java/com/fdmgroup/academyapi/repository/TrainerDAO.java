package com.fdmgroup.academyapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.academyapi.models.Academy;
import com.fdmgroup.academyapi.models.Trainer;

public interface TrainerDAO extends JpaRepository<Trainer, Integer> {

	List<Trainer> findByAcademy(Academy academy);
	
}
