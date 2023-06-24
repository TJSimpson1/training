package com.fdmgroup.academyapi.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.academyapi.models.Academy;
import com.fdmgroup.academyapi.models.Stream;
import com.fdmgroup.academyapi.models.Trainee;
import com.fdmgroup.academyapi.repository.TraineeDAO;

@Service
public class TraineeService {

	@Autowired
	private TraineeDAO traineeDAO;
	
	
	public List<Trainee> getAlltrainees(){
		return traineeDAO.findAll();	
	}
	
	public Trainee createTrainee(Trainee trainee) {
		trainee.setStartDate(new Date());
		if (! traineeDAO.existsById(trainee.getId())) {
			return traineeDAO.save(trainee);
		}
		return null;
	}
	
	public Trainee getTrainee(int traineeId) {
		Optional<Trainee> trainee = traineeDAO.findById(traineeId);
		
		if (trainee.isPresent()) {
			return trainee.get();
		}
		return null;
	}
	
	public boolean updateTrainee(Trainee trainee) {
		if (traineeDAO.existsById(trainee.getId())) {
			traineeDAO.save(trainee);
			return true;
		}
		return false;
	}
	
	public boolean removetrainee(int id) {
		if (traineeDAO.existsById(id)) {
			traineeDAO.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Trainee> getTraineesByAcademy(Academy academy){
		return traineeDAO.findByAcademy(academy);
	}
	
	public List<Trainee> getTraineesByStream(Stream stream){
		return traineeDAO.findByStream(stream);
	}
}
