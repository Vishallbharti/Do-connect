package com.demo.repositry;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.model.UserBean;

public interface UserRepositry extends CrudRepository<UserBean, Integer> {

	/**
	 * 
	 * @param email
	 * @return user by email id
	 */

	public UserBean findByEmail(String email);

	/**
	 * 
	 * @param admin
	 * @return getting list of admin
	 */
	public List<UserBean> findByAdmin(int admin);

	/**
	 * Checking candidate is exist by email
	 * 
	 * @param email
	 * @return
	 */
	public boolean existsByEmail(String email);
}
