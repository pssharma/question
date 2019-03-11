package com.questions.domain.util;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.apache.tomcat.jni.Status;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.questions.domain.api.Answer;
import com.questions.domain.controllers.AnswerController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class AnswerResourceAssembler implements ResourceAssembler<Answer, Resource<Answer>>{

	@Override
	public Resource<Answer> toResource(Answer entity) {
		
		 return new Resource<>(entity,
				linkTo(methodOn(AnswerController.class).one(entity.getId())).withSelfRel(),
				linkTo(methodOn(AnswerController.class).all()).withRel("employees"));
		 
		/* 
			 answerResource.add(linkTo(methodOn(AnswerController.class)
					 .submit(entity.getId())).withRel("submit"));*/
		 
	}

}
