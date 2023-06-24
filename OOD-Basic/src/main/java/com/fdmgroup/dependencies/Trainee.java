package com.fdmgroup.dependencies;

import java.util.List;

public class Trainee {
	private String name;

	
	public Trainee(String name) {
		super();
		this.name = name;
	}
	
	public int takeExam(Exam exam) {
		List<String> questions = exam.getAllQuestions();
		for(String eachQuestion : questions) {
			System.out.println(name + " is answering question: " + eachQuestion);
		}
		return (int) (Math.random()*100);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
