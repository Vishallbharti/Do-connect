package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Question;
import com.demo.repositry.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepository;

	// This function is return question by q id
	public Question getQuestionById(int userId) {
		return this.questionRepository.findById(userId).get();
	}

	// this function is used for inserting question into database
	public boolean insertQuestion(Question question) {
		this.questionRepository.save(question);
		return true;
	}

	// this function is returning all question
	public List<Question> getQuestion() {
		return (List<Question>) this.questionRepository.findAll();
	}
	
	
   public void approveQuestion(int id) {
	   this.questionRepository.approveQuestionById(id);
	}
	
}
