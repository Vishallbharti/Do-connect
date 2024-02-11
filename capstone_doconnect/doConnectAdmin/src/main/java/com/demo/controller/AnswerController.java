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

import com.demo.model.Answer;
import com.demo.model.Messages;
import com.demo.model.ResponsePage;
import com.demo.repositry.AnswerRepository;
import com.demo.services.AnswerService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AnswerController {

	/**
	 * @see This is the admin answer controller.
	 * @author Vishal Bharti
	 * @since 03-Jan-2022
	 */
	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private AnswerService answerService;

	/**
	 * \
	 * 
	 * @see this api is used for approving answer
	 * @param id
	 * @return response string type data
	 */

	@GetMapping("/approveAns/{id}")
	public ResponseEntity<?> approveQuetionById(@PathVariable int id) {
		System.out.println(id);
		this.answerRepository.approveAnswerById(id);
		return ResponseEntity.ok().body(new ResponsePage(Messages.SUCCESS, "You have approved answer!"));

	}

	/**
	 * @see // this api is used for getting all answer list
	 * @return list of all answer
	 * @throws Exception
	 */

	@GetMapping("/allAnswer")
	public ResponseEntity<List<Answer>> getAllQuestion() throws Exception {
		List<Answer> answers = this.answerService.getAnswers();
		return new ResponseEntity<List<Answer>>(answers, HttpStatus.OK);
	}

	/**
	 * @see this function is used for deleting an answer by id
	 * @param id
	 * @return response string type data
	 */
	// this spi is used for deleting an answer
	@DeleteMapping("/deleteAns/{id}")
	public ResponseEntity<?> deleteAnswerById(@PathVariable int id) {
		System.out.println(id);
		this.answerRepository.deleteById(id);
		return ResponseEntity.ok().body(new ResponsePage(Messages.SUCCESS, "You have successfuly deleted answer!"));

	}

}
