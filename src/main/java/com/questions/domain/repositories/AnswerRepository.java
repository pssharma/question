package com.questions.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.questions.domain.api.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long>{
	
	Optional<Answer>  findByQidAndUid(Long qid, Long uid);

}
