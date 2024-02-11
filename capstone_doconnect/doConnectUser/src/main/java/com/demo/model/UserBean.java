package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class UserBean {
	/**
	 * @see this model class is representing the data of user and getter setter
	 * @author Vishal Bharti
	 * @since 03-Jan-2022
	 */
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	@ColumnDefault("0")
	private int admin;

	public UserBean() {
		super();
	}

	public UserBean(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public UserBean(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UserBean(String name, String email, String password, int admin) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.admin = admin;
	}

	public UserBean(int id, String name, String email, String password, int admin) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", admin="
				+ admin + "]";
	}

}
