package com.fdmgroup.academyapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.academyapi.models.Course;
import com.fdmgroup.academyapi.models.ExamResult;
import com.fdmgroup.academyapi.models.Trainee;
import com.fdmgroup.academyapi.repository.ExamResultDAO;

@Service
public class ExamResultService {

	@Autowired
	private ExamResultDAO examResultDAO;
	
	
	public List<ExamResult> getAllExamResults(){
		return examResultDAO.findAll();	
	}
	
	public ExamResult createExamResult(ExamResult examResult) {
		if (examResult.getCourse() != null && examResult.getExamDate() != null && examResult.getTrainee() != null) {
			return examResultDAO.save(examResult);
		}
		return null;
	}
	
	public ExamResult getExamResult(int examResultId) {
		Optional<ExamResult> examResult = examResultDAO.findById(examResultId);
		
		if (examResult.isPresent()) {
			return examResult.get();
		}
		return null;
	}
	
	public boolean updateExamResult(ExamResult examResult) {
		if (examResultDAO.existsById(examResult.getId())) {
			examResultDAO.save(examResult);
			return true;
		}
		return false;
	}
	
	public boolean removeExamResult(int id) {
		if (examResultDAO.existsById(id)) {
			examResultDAO.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<ExamResult> getExamResultsByTrainee(Trainee trainee){
		return examResultDAO.findByTrainee(trainee);
	}
	
	public List<ExamResult> getExamResultsByTraineeId(int traineeId){
		return examResultDAO.findByTraineeId(traineeId);
	}
	
	public List<ExamResult> getExamResultsByCourse(Course course){
		return examResultDAO.findByCourse(course);
	}
	

	
}
