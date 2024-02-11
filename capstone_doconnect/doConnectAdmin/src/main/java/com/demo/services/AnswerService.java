package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Answer;
import com.demo.repositry.AnswerRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository answerRepository;

	// approve answer by id
	public void approveAnswer(int id) {
		this.answerRepository.approveAnswerById(id);
	}
	
	public List<Answer> getAnswers(){
		return (List<Answer>) this.answerRepository.findAll();
	}
	
}
