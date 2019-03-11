package com.questions.domain.api;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
   @Column(name = "id")
    private Long id;
@Column(name = "Type")
	private String type;
@Column(name = "no_of_choices")
	private int noOfChoices;
@Column(name = "answer")
	private String answer;
	
	
	 @Column(name = "options")
	private String options;
	public Question(String question, String type, int noOfChoices, String answer, String options) {
		this.question = question;
		this.type = type;
		this.noOfChoices = noOfChoices;
		this.answer = answer;
		this.options = options;
	}
	

}
