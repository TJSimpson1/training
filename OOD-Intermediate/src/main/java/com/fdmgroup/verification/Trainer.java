package com.fdmgroup.verification;

public interface Trainer {

	void teach();
	void prepareLesson();
	void invigilateExam(String topic);
	void reviewTraineeCode(Trainee trainee);

}
