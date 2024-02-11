package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Answer;
import com.demo.model.Messages;
import com.demo.model.Question;
import com.demo.model.ResponsePage;
import com.demo.services.AnswerService;
import com.demo.services.QuestionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@CrossOrigin
public class AnswerController {
	/**
	 * @see this is the user answer controller
	 * @author Vishal Bharti
	 * @since 03-Jan-2022
	 */
	@Autowired
	private AnswerService answerService;

	@Autowired
	private QuestionService questionService;

	/**
	 * @see this api is used for inserting answer by user
	 * @param answer
	 * @return response string data
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */

	@PostMapping("/insertAns")
	public ResponseEntity<?> userRegister(@RequestBody Answer answer)
			throws JsonMappingException, JsonProcessingException {
		if (this.answerService.insertAnswer(answer)) {
			String emailSub = "New answer posted: \n [Topic]: " + answer.getQuestion().getTopic();
			String emailBody = "Question Description: " + answer.getQuestion().getDescription() + "\n" + "\n"
					+ "Answer..\n" + answer.getDescription();
			questionService.sendmail(emailSub, emailBody);

			return ResponseEntity.ok().body(new ResponsePage(Messages.SUCCESS, "You have successfuly posted answer!"));

		}
		return ResponseEntity.badRequest().body(new ResponsePage(Messages.FAILURE, "You can not post answer!"));

	}
}
