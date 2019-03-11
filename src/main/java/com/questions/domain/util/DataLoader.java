package com.questions.domain.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.questions.domain.api.Question;
import com.questions.domain.repositories.QuestionRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class DataLoader {
	
	@Bean
	CommandLineRunner initDB(QuestionRepository questionRepository) {
		return args ->{
			
			log.info("Preloading " + questionRepository.save(new Question("Three of these Italian F1 drivers won the Italian Grand Prix on at least one occasion - which one did not?",
					"trivia",  1, "Michele Alboreto",Stream.of("Alberto Ascari", "Giuseppe Nino Farina","Ludovico Scarfiotti","Michele Alboreto").collect(Collectors.toList()))));
			
			log.info("Preloading " + questionRepository.save(new Question("Lewis Hamilton won his first F1 world championship title with which team?",
					"trivia",  1, "McLaren", Stream.of("McLaren", "Mercedes").collect(Collectors.toList()))));
		};
	}

}
