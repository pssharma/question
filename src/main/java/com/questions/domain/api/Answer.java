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
import javax.jdo.annotations.Index;

import org.springframework.stereotype.Indexed;

import lombok.Data;

@Data
@Entity
@Table(name ="answers")
//@Index(members={"qid","uid"})
public class Answer {
	private @Id @GeneratedValue Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="qid")
	private Long qid;
	
	private Long uid;
	
	@ElementCollection
	private List<String> userAnswers;

	private String correctAnswer;
	
	public Answer(Long qid,Long uid,List<String> userAnswers,String correctAnswer) {
		this.correctAnswer = correctAnswer;
		this.userAnswers = userAnswers;
		this.uid = uid;
		this.qid = qid;
	}

}
