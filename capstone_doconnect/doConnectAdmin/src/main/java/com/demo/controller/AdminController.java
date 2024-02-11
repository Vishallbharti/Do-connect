package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.AdminBean;
import com.demo.model.Messages;
import com.demo.model.ResponsePage;
import com.demo.services.AdminBeanService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

	// Instance variable of UserBeanService class
	@Autowired
	private AdminBeanService adminBeanService;

	/**
	 * @see this function is used for admin login
	 * @param userBean
	 * @param httpSession
	 * @return Response String type data
	 * @author Vishal Bharti
	 * @since 03-Jan-2022
	 * @throws Exception
	 */
	@PostMapping("/login")
	public ResponseEntity<?> postLogin(@RequestBody AdminBean userBean, HttpSession httpSession) throws Exception {
		// if register parameter is null
		if (this.adminBeanService.userValidation(userBean) == 1) {
			return ResponseEntity.ok().body(new ResponsePage(Messages.SUCCESS, "login success"));

		}
		return ResponseEntity.badRequest().body(new ResponsePage(Messages.FAILURE, "username or password is wrong!"));
	}

	/**
	 * @see this api is used for admin register
	 * @param userBean
	 * @return Response String type data
	 * @author Vishal Bharti
	 * @since 03-Jan-2022
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@PostMapping("/adminRegister")
	// This function is used for registration for admin
	public ResponseEntity<?> getAdminRegister(@RequestBody AdminBean userBean)
			throws JsonMappingException, JsonProcessingException {
		if (adminBeanService.insertUser(userBean)) {
			return ResponseEntity.ok().body(new ResponsePage(Messages.SUCCESS, "You have successfuly register!"));

		}
		return ResponseEntity.badRequest().body(new ResponsePage(Messages.FAILURE, "You have already registered!"));

	}

	/**
	 * @see This function is used for creating an user by admin
	 * @param userBean
	 * @return This api returning string type data
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@PostMapping("/createUser")
	public ResponseEntity<?> createUser(@RequestBody AdminBean userBean)
			throws JsonMappingException, JsonProcessingException {
		userBean.setAdmin(0);
		if (adminBeanService.insertUser(userBean)) {
			return ResponseEntity.ok().body(new ResponsePage(Messages.SUCCESS, "You have successfuly created user!"));

		}
		return ResponseEntity.badRequest().body(new ResponsePage(Messages.FAILURE, "You have already this user!"));

	}

	/**
	 * @see this api is used for logout the admin
	 * @param httpSession
	 * @return Response string type data
	 * @author Vishal Bharti
	 */
	@GetMapping("/logout")
	public String getLogout(HttpSession httpSession) {
		// removing attributes from session
		httpSession.removeAttribute("email");
		httpSession.removeAttribute("userId");
		httpSession.removeAttribute("name");
		return "login";
	}

	@GetMapping("/allAdmin")
	public ResponseEntity<List<AdminBean>> getAdmin() throws Exception {
		List<AdminBean> Users = this.adminBeanService.getAllAdmin();
		return new ResponseEntity<List<AdminBean>>(Users, HttpStatus.OK);
	}

	/**
	 * @see this function is used for deleting user
	 * @param id
	 * @return response string type data
	 * @author Vishal Bharti
	 * @since 03-Jan-2022
	 */
	@DeleteMapping("/deleteUser/{id}")
	// This function is used for deleting book from database
	public ResponseEntity<?> deleteUser(@PathVariable int id) {
		if (this.adminBeanService.deleteUser(id)) {
			return ResponseEntity.ok().body(new ResponsePage(Messages.SUCCESS, "User deleted successfuly!"));

		}
		return ResponseEntity.badRequest().body(new ResponsePage(Messages.FAILURE, "User can not delete!"));

	}

	/**
	 * @see this api is used for getting user detail by user id
	 * @param uId
	 * @return user data
	 * @author Vishal Bharti
	 * @since 03-Jan-2022
	 */
	@GetMapping("/user/{uId}")
	public ResponseEntity<AdminBean> getUpdate(@PathVariable String uId) {
		int userId = Integer.parseInt(uId);
		// getting book by book id
		AdminBean user = this.adminBeanService.getUserById(userId);
		return new ResponseEntity<AdminBean>(user, HttpStatus.OK);
	}

	/**
	 * @see this api is used for editing an user details
	 * @param userBean
	 * @return response string type data
	 * @author Vishal Bharti
	 * @since 03-Jan-2022
	 */
	@PutMapping("/editUser")
	public ResponseEntity<?> updateUser(@RequestBody AdminBean userBean) {
		if (this.adminBeanService.updateUser(userBean)) {
			return ResponseEntity.ok().body(new ResponsePage(Messages.SUCCESS, "User updated successfuly!"));

		}
		return ResponseEntity.badRequest().body(new ResponsePage(Messages.FAILURE, "User can not update this user!"));

	}

	/**
	 * @see this api is used for getting user detail by email id
	 * @param email
	 * @return user details
	 * @throws Exception
	 * @author Vishal Bharti
	 * @since 03-Jan-2022
	 */
	@GetMapping("/getUserByEmail/{email}")
	public AdminBean getUserByEmail(@PathVariable String email) throws Exception {
		return adminBeanService.getUserBean(email);
	}
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<AdminBean>> getAllUsers(){
		List<AdminBean> users = this.adminBeanService.getAllUser();
		return new ResponseEntity<List<AdminBean>>(users, HttpStatus.OK);
	}
}
