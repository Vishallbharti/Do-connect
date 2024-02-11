package com.demo.repositry;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Answer;

@Transactional
public interface AnswerRepository extends CrudRepository<Answer, Integer> {
	/**
	 * @see this function is used update answer
	 * @param id
	 */
	@Modifying
	@Query(value = "UPDATE answer SET approval = 1 WHERE ans_id = ?1", nativeQuery = true)
	public void approveAnswerById(int id);
}
