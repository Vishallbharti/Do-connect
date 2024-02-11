package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Answer;
import com.demo.repositry.AnswerRepository;

@Service
public class AnswerService {
	/**
	 * @see this is answer service layer
	 * @author Vishal Bharti
	 * @since 03-Jan-2022
	 */
	@Autowired
	private AnswerRepository answerRepository;
	
	/**
	 * @see this function is used for posting answer of a particular function
	 * @param answer
	 * @return boolean value
	 */
	// this function is used for inserting answer into database
	public boolean insertAnswer(Answer answer) {
		this.answerRepository.save(answer);
		return true;
	}
}
