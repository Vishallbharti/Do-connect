package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Question;
import com.demo.repositry.QuestionRepository;

@Service
public class QuestionService {
	/**
	 * @see this is the user question service layer
	 * @author Vishal Bharti
	 * @since 03-Jan-2022
	 */
	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private EnableSenderService sendersevice;

	/**
	 * 
	 * @param queId
	 * @return This function is return question by id
	 */
	public Question getQuestionById(int queId) {
		return this.questionRepository.findById(queId).get();
	}

	/**
	 * 
	 * @param question
	 * @return this function is used for inserting question into database
	 */
	public boolean insertQuestion(Question question) {
		this.questionRepository.save(question);
		return true;
	}

	/**
	 * 
	 * @return this function is returning all question
	 */
	public List<Question> getQuestion() {
		return (List<Question>) this.questionRepository.findAll();
	}

	/**
	 * @see email functionality
	 * @param subject
	 * @param body
	 */
	public void sendmail(String subject, String body) {
		sendersevice.sendEmail("alok.sinha2017@vitstudent.ac.in", subject, body);
		sendersevice.sendEmail("vishal210198p@gmail.com", subject, body);
	}

}
