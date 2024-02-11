package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.AdminBean;
import com.demo.repositry.AdminRepositry;

@Service
public class AdminBeanService {
	/**
	 * @see this is the admin service
	 * @author Vishal Bharti
	 * @since 03-Jan-2022
	 * 
	 */
	@Autowired
	private AdminRepositry adminRepositry;

	/**
	 * @see This function is return user by user id
	 * @param userId
	 * @return user details
	 */
	public AdminBean getUserById(int userId) {
		return this.adminRepositry.findById(userId).get();
	}

	/**
	 * @see this function is used for registering admin
	 * @param user
	 * @return boolean value
	 */

	public boolean insertUser(AdminBean user) {
		user.setAdmin(1);
		if (this.adminRepositry.existsByEmail(user.getEmail())) {
			return false;
		}
		this.adminRepositry.save(user);
		return true;
	}

	/**
	 * @see This function is used for creating new user by admin
	 * @param user
	 * @return
	 */
	public boolean createUser(AdminBean user) {
		user.setAdmin(0);
		if (this.adminRepositry.existsByEmail(user.getEmail())) {
			return false;
		}
		this.adminRepositry.save(user);
		return true;
	}

	/**
	 * @see This function is used for getting user by email id
	 * @param email
	 * @return user details
	 * @throws Exception
	 */
	public AdminBean getUserBean(String email) throws Exception {
		return this.adminRepositry.findByEmail(email);
	}

	/**
	 * @see Validating user with their credentials
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int userValidation(AdminBean user) throws Exception {
		// if user is exist
		if (getUserBean(user.getEmail()) != null) {
			for (AdminBean loginUser : getAllUserAdmin()) {
				// if user provided valid credentials
				if (loginUser.getPassword().equals(user.getPassword()) && loginUser.getAdmin() == 1) {
					return 1;
				}
			}
			return 2;
		}
		return 3;
	}

	/**
	 * @see Getting list of all users
	 * @return list of users
	 */
	public List<AdminBean> getAllUser() {
		return this.adminRepositry.findByAdmin(0);
	}

	/**
	 * 
	 * @return Getting list of all admin
	 */
	public List<AdminBean> getAllAdmin() {
		return this.adminRepositry.findByAdmin(1);
	}

	/**
	 * 
	 * @return Getting list of all user and admin
	 */
	public List<AdminBean> getAllUserAdmin() {
		return (List<AdminBean>) this.adminRepositry.findAll();
	}

	/**
	 * 
	 * @param userId
	 * @return This function is used for deleting an user by admin
	 */
	public boolean deleteUser(int userId) {
		if (this.adminRepositry.existsById(userId)) {
			this.adminRepositry.deleteById(userId);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param user
	 * @return This function is used for updation user details
	 */
	public boolean updateUser(AdminBean user) {
		if (this.adminRepositry.existsById(user.getId())) {
			this.adminRepositry.save(user);
			return true;
		} else {
			return false;
		}

	}
}
