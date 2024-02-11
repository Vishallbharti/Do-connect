package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Messages;
import com.demo.model.Question;
import com.demo.model.ResponsePage;
import com.demo.repositry.QuestionRepository;
import com.demo.services.QuestionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class QuestionController {

	/**
	 * @see this is the admin question controller
	 * @author Vishal Bharti
	 * @since 03-Jan-2022
	 */
	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuestionRepository questionRepository;

	/**
	 * @see this api is used for getting all question
	 * @return List of all question
	 * @throws Exception
	 */
	@GetMapping("/allQuestion")
	public ResponseEntity<List<Question>> getAllQuestion() throws Exception {
		List<Question> questions = this.questionService.getQuestion();
		return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
	}

	/**
	 * @see this api is used for approving a question
	 * @param id
	 * @return response string type data
	 */
	@GetMapping("/approveQue/{id}")
	public ResponseEntity<?> approveQuetionById(@PathVariable int id) {
		this.questionService.approveQuestion(id);
		return ResponseEntity.ok().body(new ResponsePage(Messages.SUCCESS, "You have approved question!"));

	}

	/**
	 * @see this api is used for deleting a question
	 * @param id
	 * @return response string data type
	 */

	@DeleteMapping("/deleteQue/{id}")
	public ResponseEntity<?> deleteQuestionById(@PathVariable int id) {
		this.questionRepository.deleteById(id);
		return ResponseEntity.ok().body(new ResponsePage(Messages.SUCCESS, "You have successfuly deleted question!"));

	}

}
