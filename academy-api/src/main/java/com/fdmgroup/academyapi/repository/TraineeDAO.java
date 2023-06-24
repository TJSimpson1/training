package com.fdmgroup.academyapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.academyapi.models.Academy;
import com.fdmgroup.academyapi.models.Stream;
import com.fdmgroup.academyapi.models.Trainee;

public interface TraineeDAO extends JpaRepository<Trainee, Integer> {

	List<Trainee> findByAcademy(Academy academy);
	List<Trainee> findByStream(Stream stream);
	
}
