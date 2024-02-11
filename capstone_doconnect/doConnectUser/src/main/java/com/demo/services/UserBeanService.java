package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.UserBean;
import com.demo.repositry.UserRepositry;

@Service
public class UserBeanService {
	/**
	 * @see this is the user service layer
	 * @author Vishal Bharti
	 * @since 02-Jan-2022
	 */
	// Instance variable of UserRepositry
	@Autowired
	private UserRepositry userRepositry;

	/**
	 * 
	 * @param userId
	 * @return This function is return user by user id
	 */
	public UserBean getUserById(int userId) {
		return this.userRepositry.findById(userId).get();
	}

	/**
	 * 
	 * @param user
	 * @return this function is used for inserting user into database
	 */

	public boolean insertUser(UserBean user) {
		if (this.userRepositry.existsByEmail(user.getEmail())) {
			return false;
		}
		this.userRepositry.save(user);
		return true;
	}

	/**
	 * 
	 * @param email
	 * @return This function is used for getting user by email id
	 * @throws Exception
	 */
	//
	public UserBean getUserBean(String email) throws Exception {
		return this.userRepositry.findByEmail(email);
	}

	/**
	 * 
	 * @param user
	 * @return Validating user with their credentials
	 * @throws Exception
	 */
	public int userValidation(UserBean user) throws Exception {
		// if user is exist
		if (getUserBean(user.getEmail()) != null) {
			for (UserBean loginUser : getAllUserAdmin()) {
				// if user provided valid credentials
				if (loginUser.getPassword().equals(user.getPassword()) && loginUser.getAdmin() == 0) {
					return 1;
				}
			}
			return 2;
		}
		return 3;
	}

	/**
	 * 
	 * @return Getting list of all user and admin
	 */
	//
	public List<UserBean> getAllUserAdmin() {
		return (List<UserBean>) this.userRepositry.findAll();
	}

}
