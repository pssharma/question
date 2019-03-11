package com.questions.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.questions.domain.api.Question;

public interface QuestionRepository extends  JpaRepository<Question, Long>{

}
