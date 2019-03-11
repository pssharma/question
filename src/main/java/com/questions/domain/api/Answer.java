package com.questions.domain.api;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.jdo.annotations.Index;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@Entity
@Table(name ="answers")
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
//@Index(members={"qid","uid"})
public class Answer {
	@Id 
	@GeneratedValue  
	@Column(name = "id")
	 private Long id;
	
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="qid")

	@Column(name="qid")
	private Long qid;
	
	
	@Column(name="uid")
	private Long uid;
	
	
	@Column(name="user_answers")
	private String userAnswers;

	@Column(name="answer")
	private String correctAnswer;
	
	//@Builder
	public Answer(Long qid,Long uid,String userAnswers,String correctAnswer) {
		this.correctAnswer = correctAnswer;
		this.userAnswers = userAnswers;
		this.uid = uid;
		this.qid = qid;
	}

}
