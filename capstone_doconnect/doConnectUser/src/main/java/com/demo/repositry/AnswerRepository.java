package com.demo.repositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Integer>{

}
