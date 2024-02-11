package com.demo.repositry;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.AdminBean;

@Repository
public interface AdminRepositry extends CrudRepository<AdminBean, Integer> {

	/**
	 * @see this function is used for getting all user data by email id
	 * @param email
	 * @return user details
	 */
	// find user by email id
	public AdminBean findByEmail(String email);

	/**
	 * 
	 * @param admin
	 * @return user data by admin type
	 */
	// getting list of admin
	public List<AdminBean> findByAdmin(int admin);

	/**
	 * 
	 * @param email
	 * @return user details
	 */
	// Checking candidate is exist by email
	public boolean existsByEmail(String email);
}
