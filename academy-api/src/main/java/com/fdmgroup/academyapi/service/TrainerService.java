package com.fdmgroup.academyapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.academyapi.models.Academy;
import com.fdmgroup.academyapi.models.Course;
import com.fdmgroup.academyapi.models.Trainer;
import com.fdmgroup.academyapi.repository.TrainerDAO;

@Service
public class TrainerService {

	@Autowired
	private TrainerDAO trainerDAO;
	
	
	public List<Trainer> getAllTrainers(){
		return trainerDAO.findAll();	
	}
	
	public Trainer createTrainer(Trainer trainer) {
		if (! trainerDAO.existsById(trainer.getId())) {
			return trainerDAO.save(trainer);
		}
		return null;
	}
	
	public Trainer getTrainer(int id) {
		Optional<Trainer> trainer = trainerDAO.findById(id);
		
		if (trainer.isPresent()) {
			return trainer.get();
		}
		return null;
	}
	
	public boolean updateTrainer(Trainer trainer) {
		if (trainerDAO.existsById(trainer.getId())) {
			trainerDAO.save(trainer);
			return true;
		}
		return false;
	}
	
	public boolean removeTrainer(int id) {
		if (trainerDAO.existsById(id)) {
			trainerDAO.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Trainer> listTrainersByAcademy(Academy academy){
		return trainerDAO.findByAcademy(academy);
	}
	
	public List<Trainer> listTrainersByCourse(Course course){
		List<Trainer> trainers = trainerDAO.findAll();
		
		trainers.removeIf(trainer -> ! trainer.getCourses().contains(course));
		
		return trainers;
	}
	
}
