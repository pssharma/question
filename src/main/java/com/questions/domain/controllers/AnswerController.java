package com.questions.domain.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Status;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.questions.domain.Exceptions.AnswerNotFoundException;
import com.questions.domain.api.Answer;
import com.questions.domain.api.Question;
import com.questions.domain.repositories.AnswerRepository;
import com.questions.domain.repositories.QuestionRepository;
import com.questions.domain.util.AnswerResourceAssembler;



import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
public class AnswerController {
	
	private final AnswerRepository answerRepository;
	private final QuestionRepository questionRepository;
	private final AnswerResourceAssembler answerResourceAssembler;
	public AnswerController(AnswerRepository answerRepository, AnswerResourceAssembler answerResourceAssembler,QuestionRepository questionRepository) {
	
		this.answerRepository = answerRepository;
		this.answerResourceAssembler = answerResourceAssembler;
		this.questionRepository = questionRepository;
	}
	
	//check for duplicates with qid and uid
	
	@GetMapping("/answers")
	public Resources<Resource<Answer>> all() {

		List<Resource<Answer>> Answers = answerRepository.findAll().stream()
			.map(answerResourceAssembler::toResource)
			.collect(Collectors.toList());

		return new Resources<>(Answers,
			linkTo(methodOn(AnswerController.class).all()).withSelfRel());
	}

	@GetMapping("/answers/{id}")
	public Resource<Answer> one(@PathVariable Long id) {
		return answerResourceAssembler.toResource(
			answerRepository.findById(id)
				.orElseThrow(() -> new AnswerNotFoundException(id)));
	}

	@RequestMapping(value="/answers",headers="Accept=application/json", method=RequestMethod.POST)
	public ResponseEntity<Resource<Answer>> newAnswer(@RequestBody Answer answer) {

	
		//Answer newAnswer = answerRepository.save(answer);
		//boolean correctAnswer = false;
		
		//checking if answer already exists
		Answer answerNew = new Answer(answer.getId(),answer.getQid(),answer.getUid(),answer.getUserAnswers(),"");
		
		Optional<Answer> newAnswer = answerRepository.findByQidAndUid(answer.getQid(), answer.getUid());
	
		
		if(newAnswer.isPresent()) {
		
		answerNew = newAnswer.get();
		answerNew.setUserAnswers(answer.getUserAnswers());

		//checking if the answer is for trivia.
			
		Question question = questionRepository.getOne(newAnswer.get().getQid());
		if(question.getType().equals("trivia")) {
			//assuming we will filter only one option for trivia on frontend
			answer.setCorrectAnswer(question.getAnswer());	
			}
		
		answerRepository.save(answerNew);
		
		}
		
		/*else {
			answerNew = new Answer(answer.getId(),answer.getQid(),answer.getUid(),answer.getUserAnswers(),"");
			answerRepository.save(answerNew);
		}*/
		
		return ResponseEntity
				.created(linkTo(methodOn(AnswerController.class).one(answerNew.getId())).toUri())
				.body(answerResourceAssembler.toResource(answerNew));
		
	}
	
	/*
	 * @PutMapping("/answers/{id}/submit") ResponseEntity<ResourceSupport>
	 * submit(@PathVariable Long id) {
	 * 
	 * Answer answer = answerRepository.findById(id).orElseThrow(() -> new
	 * AnswerNotFoundException(id)); //logging for updating
	 * 
	 * 
	 * return
	 * ResponseEntity.ok(answerResourceAssembler.toResource(answerRepository.save(
	 * answer)));
	 * 
	 * 
	 * return ResponseEntity .status(HttpStatus.METHOD_NOT_ALLOWED) .body(new
	 * VndErrors.VndError("Method not allowed",
	 * "You can't complete the submission that is in the " + answer.getStatus() +
	 * " status")); }
	 */
	

}
