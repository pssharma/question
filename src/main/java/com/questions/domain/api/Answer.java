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

import org.springframework.stereotype.Indexed;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name ="answers")
//@Index(members={"qid","uid"})
public class Answer {
	private @Id @GeneratedValue  @Column(name = "id")
	Long id;
	
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="qid")
	@NotEmpty
	@Column(name="qid")
	private Long qid;
	
	@NotEmpty
	@Column(name="uid")
	private Long uid;
	
	
	@Column(name="user_answers")
	private String userAnswers;

	@Column(name="answer")
	private String correctAnswer;
	
	@Builder
	public Answer(Long qid,Long uid,String userAnswers) {
		//this.correctAnswer = correctAnswer;
		this.userAnswers = userAnswers;
		this.uid = uid;
		this.qid = qid;
	}

}
