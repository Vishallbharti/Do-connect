package com.demo.repositry;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Chatting;

@Repository
public interface ChattingRepository extends CrudRepository<Chatting, Integer>{
   public List<Chatting> findByToUserId(int toUserId);
}
