package com.questions.domain.Exceptions;

public class AnswerNotFoundException extends RuntimeException{

	public AnswerNotFoundException(Long id) {
		super("Could not find the question "+id);
	}

}
