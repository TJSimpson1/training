package com.fdmgroup.academyapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fdmgroup.academyapi.models.Course;
import com.fdmgroup.academyapi.models.ExamResult;
import com.fdmgroup.academyapi.models.Trainee;

public interface ExamResultDAO extends JpaRepository<ExamResult, Integer> {

	List<ExamResult> findByTrainee(Trainee trainee);
	List<ExamResult> findByCourse(Course course);


	@Query("SELECT e from exam_results e WHERE e.trainee.id = :traineeId")
	List<ExamResult> findByTraineeId(@Param("traineeId") int traineeId);
	
}
