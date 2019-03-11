package com.questions.domain.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.questions.domain.api.Question;
import com.questions.domain.repositories.AnswerRepository;
import com.questions.domain.repositories.QuestionRepository;

class QuestionControllerTest {
	@Mock
	QuestionRepository questionRepository;
	
	@InjectMocks
	QuestionController questionController;
	MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(questionController).build();
		
	}

	@Test
	void testAll() throws Exception {

		Question Question1 = new Question("Hey you?","poll",1,null,"hello::whatever");
		Question Question2 = new Question("what color is sky?","trivia",1,"Blue","Blue::Red");
		
		questionRepository.save(Question1);
		questionRepository.save(Question2);
			
		// when(questionController.all()).thenReturn(Stream.of(Question1., Question2).collect(Collectors.toList()));
        mockMvc.perform(get("/questions/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.questions", hasSize(2)));
		
	}

	@Test
	void testOne() {
		fail("Not yet implemented");
	}

}
