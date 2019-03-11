package com.questions.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.questions.domain.api.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long>{

}
