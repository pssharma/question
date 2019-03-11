package com.questions.domain.util;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.questions.domain.api.Question;
import com.questions.domain.controllers.QuestionController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class QuestionResourceAssembler implements ResourceAssembler<Question, Resource<Question>>{

	@Override
	public Resource<Question> toResource(Question entity) {
		
		return new Resource<>(entity,
				linkTo(methodOn(QuestionController.class).one(entity.getId())).withSelfRel(),
				linkTo(methodOn(QuestionController.class).all()).withRel("employees")); 
		
	}

}
