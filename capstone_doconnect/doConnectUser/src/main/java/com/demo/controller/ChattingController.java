package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Chatting;
import com.demo.model.Messages;
import com.demo.model.ResponsePage;
import com.demo.model.UserBean;
import com.demo.repositry.ChattingRepository;
import com.demo.services.ChattingService;
import com.demo.services.UserBeanService;

@RestController
@CrossOrigin
public class ChattingController {
	/**
	 * @see This is chatting controller for one to one chatting
	 * @author Vishal Bharti
	 * @since 06-Jan-2022
	 */
	@Autowired
	private ChattingRepository chattingRepository;
	@Autowired
	private ChattingService chattingService;

	@Autowired
	private UserBeanService userBeanService;
	/**
	 * 
	 * @param chatting object
	 * @return Response string data type
	 */
	@PostMapping("/insertMessage")
	public ResponseEntity<?> insertMessage(@RequestBody Chatting chatting) {

		if (this.chattingService.insertMessage(chatting)) {
			return ResponseEntity.ok().body(new ResponsePage(Messages.SUCCESS, "You have successfuly sent message!"));

		}
		return ResponseEntity.badRequest().body(new ResponsePage(Messages.FAILURE, "You can not send message!"));

	}

	/**
	 * 
	 * @param id
	 * @return message data for particular user
	 * @throws Exception
	 */
	@GetMapping("/userMsg/{email}")
	public ResponseEntity<List<Chatting>> getQuestionById(@PathVariable String email) throws Exception {
		UserBean user = this.userBeanService.getUserBean(email);
		System.out.println("Getting msg");
		List<Chatting> messages = this.chattingRepository.findByToUserId(user.getId());
		return new ResponseEntity<List<Chatting>>(messages, HttpStatus.OK);
	}
}
