package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Chatting;
import com.demo.repositry.ChattingRepository;

@Service
public class ChattingService {
	/**
	 * @see This is the chatting servic layer
	 * @author Vishal Bharti
	 * @since 06-Jan-2022
	 */
	@Autowired
	private ChattingRepository chattingRepository;

	/**
	 * 
	 * @param chatting
	 * @return boolean value
	 */
	public boolean insertMessage(Chatting chatting) {
		this.chattingRepository.save(chatting);
		return true;
	}

}
