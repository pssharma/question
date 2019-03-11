package com.questions.domain.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import com.questions.domain.Exceptions.QuestionNotFoundException;
import com.questions.domain.api.Question;
import com.questions.domain.repositories.QuestionRepository;
import com.questions.domain.util.QuestionResourceAssembler;

@RestController
public class QuestionController {
	
	private final QuestionRepository questionRepository;
	private final QuestionResourceAssembler questionResourceAssembler;

	public QuestionController(QuestionRepository questionRepository,QuestionResourceAssembler questionResourceAssembler) {
		this.questionRepository = questionRepository;
		this.questionResourceAssembler = questionResourceAssembler;
	}
	
	
	@GetMapping("/questions")
	public Resources<Resource<Question>> all() {

		List<Resource<Question>> questions = questionRepository.findAll().stream()
			.map(questionResourceAssembler::toResource)
			.collect(Collectors.toList());

		return new Resources<>(questions,
			linkTo(methodOn(QuestionController.class).all()).withSelfRel());
	}
	
	@PostMapping("/questions")
	public Question question1(@RequestBody Question question1) {
		return questionRepository.save(question1);
	}
	
	@GetMapping("/questions/{id}")
	public Resource<Question> one(@PathVariable Long id) {
        Question question = questionRepository.findById(id)
        		.orElseThrow(() -> new QuestionNotFoundException(id));
        
       // Link oneLink = linkTo(methodOn(QuestionController.class).one(id)).withSelfRel();
        //Link allLink = linkTo(methodOn(QuestionController.class).all()).withRel("questions");
		//return new Resource<>(question,oneLink,allLink);
        return questionResourceAssembler.toResource(question);
	}
				
				
		
	}
	
	
	


