package com.demo.repositry;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Question;

@Transactional
public interface QuestionRepository extends CrudRepository<Question, Integer> {
	/**
	 * this function is used for updating a question
	 */
	@Modifying
	@Query(value = "UPDATE question SET approval = 1 WHERE que_id = ?1", nativeQuery = true)
	public void approveQuestionById(int id);

}
