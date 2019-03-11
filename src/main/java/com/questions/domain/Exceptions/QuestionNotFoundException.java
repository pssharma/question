package com.questions.domain.Exceptions;

public class QuestionNotFoundException extends RuntimeException{

	public QuestionNotFoundException(Long id) {
		super("Could not find the question "+id);
	}
	
	

}
