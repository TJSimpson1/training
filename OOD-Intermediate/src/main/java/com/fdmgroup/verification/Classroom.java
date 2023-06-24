package com.fdmgroup.verification;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
	private Trainer trainer;
	private List<Trainee> trainees = new ArrayList<>();
	
	public void startLesson() {
		trainer.teach();
		for(Trainee eachTrainee : trainees) {
			eachTrainee.learn();
		}
		
	}
	public void endLesson() {
		trainer.prepareLesson();
		
	}
	public void startExam(String topic) {
		trainer.invigilateExam(topic);
		
	}
	
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public List<Trainee> getTrainees() {
		return trainees;
	}
	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}
	public void reviewAllTraineesCode() {
		for(Trainee eachTrainee : trainees) {
			trainer.reviewTraineeCode(eachTrainee);
		}
		
	}
	
	
	
	

}
