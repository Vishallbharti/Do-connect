package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Messages;
import com.demo.model.ResponsePage;
import com.demo.model.UserBean;
import com.demo.services.UserBeanService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@CrossOrigin
public class UserController {

	/**
	 * @see this is the user controller
	 * @author Vishal Bharti
	 * @since 03-Jan-2022
	 */
	// Instance variable of UserBeanService class
	@Autowired
	private UserBeanService userBeanService;

	/**
	 * @see This function is used to login an user
	 * @param userBean
	 * @param httpSession
	 * @return response string type data
	 * @throws Exception
	 */
	@PostMapping("/login")
	public ResponseEntity<?> postLogin(@RequestBody UserBean userBean, HttpSession httpSession) throws Exception {

		if (this.userBeanService.userValidation(userBean) == 1) {
			return ResponseEntity.ok().body(new ResponsePage(Messages.SUCCESS, "login success"));

		}
		return ResponseEntity.badRequest().body(new ResponsePage(Messages.FAILURE, "username or password is wrong!"));

	}

	/**
	 * 
	 * @param userBean
	 * @return response string type data
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@PostMapping("/register")
	// This function used to registration of an user
	public ResponseEntity<?> userRegister(@RequestBody UserBean userBean)
			throws JsonMappingException, JsonProcessingException {
		if (userBeanService.insertUser(userBean)) {
			return ResponseEntity.ok().body(new ResponsePage(Messages.SUCCESS, "You have successfuly register!"));

		}
		return ResponseEntity.badRequest().body(new ResponsePage(Messages.FAILURE, "You have already registered!"));

	}

	/**
	 * 
	 * @param userBean
	 * @return user details
	 * @throws Exception
	 */
	@PostMapping("/getUserByEmail")
	public UserBean getUserByEmail(@RequestBody UserBean userBean) throws Exception {
		return userBeanService.getUserBean(userBean.getEmail());
	}
}
