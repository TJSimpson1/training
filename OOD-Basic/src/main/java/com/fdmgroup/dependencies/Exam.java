package com.fdmgroup.dependencies;

import java.util.ArrayList;
import java.util.List;

public class Exam {
	private List<String> questions = new ArrayList<String>();
	
	public void addQuestions(String question) {
		questions.add(question);
	}
	
	public List<String> getAllQuestions() {
		return questions;
	}
}
