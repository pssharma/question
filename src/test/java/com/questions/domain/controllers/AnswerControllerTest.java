package com.questions.domain.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.questions.domain.api.Answer;
import com.questions.domain.repositories.AnswerRepository;

class AnswerControllerTest {
	
	
	AnswerRepository answerRepository;
	
	@InjectMocks
	AnswerController answerController;
	
	MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
       MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(answerController).build();
	}



	@Test
	void testNewAnswer() {
		
		Answer Answer1 = new Answer(1L,2L,"Blue");
		Answer1.setId(1L);
		Answer Answer2 = new Answer(Answer1.getQid(),Answer1.getUid(),"Green");
		Answer2.setId(2L);
		answerController.newAnswer(Answer1);
		answerController.newAnswer(Answer2);
		assertEquals(1, answerRepository.findAll());

        

        

      
	}



}
