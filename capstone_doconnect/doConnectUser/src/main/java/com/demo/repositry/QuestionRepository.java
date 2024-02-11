package com.demo.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demo.model.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

	/**
	 * 
	 * @param approved_type
	 * @return list of answer which are approved by the admin
	 */
	public List<Question> findByApproval(int approved_type);

	/**
	 * 
	 * @return return all question and answer which are aprroved by the admin
	 */
	@Query(value = "select * from question left join answer On (answer.question_que_id = question.que_id) Where question.approval = 1 and answer.approval = 1 ", nativeQuery = true)
	public List<Question> findQuestionByAnswerApproval();

}
