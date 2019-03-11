package com.questions.domain.api;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name ="questions")
public class Question {
	
private String question;

   

@Id
   @GeneratedValue
  
    private Long id;
	private String type;

	private int noOfChoices;

	private String answer;
	
	 @ElementCollection
	private List<String> options;
	public Question(String question, String type, int noOfChoices, String answer, List<String> options) {
		this.question = question;
		this.type = type;
		this.noOfChoices = noOfChoices;
		this.answer = answer;
		this.options = options;
	}
	

}
