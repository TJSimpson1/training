package com.fdmgroup.dependencies;

public class Runner {

	public static void main(String[] args) {
		Exam exam = new Exam();
		
		exam.addQuestions("What are the different types of loops?");
		exam.addQuestions("What's the difference between an object and a class?");
		exam.addQuestions("What is a reference?");
		
		Trainee trainee = new Trainee("John");
		
		int score = trainee.takeExam(exam);
		
		System.out.println(trainee.getName() + " has scored " + score);
		

	}

}
