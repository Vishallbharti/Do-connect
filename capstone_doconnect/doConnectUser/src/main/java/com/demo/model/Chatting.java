package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chatting {
	/**
	 * @see this is the chatting model class which represent data and getter setter
	 * @author Vishal Bharti
	 * @since 06-Jan-2022
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String subject;
	private String description;
	private int fromUserId;
	private int toUserId;

	public Chatting() {
		super();
	}

	public Chatting(String subject, String description, int fromUserId, int toUserId) {
		super();
		this.subject = subject;
		this.description = description;
		this.fromUserId = fromUserId;
		this.toUserId = toUserId;
	}

	public Chatting(int id, String subject, String description, int fromUserId, int toUserId) {
		super();
		this.id = id;
		this.subject = subject;
		this.description = description;
		this.fromUserId = fromUserId;
		this.toUserId = toUserId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(int fromUserId) {
		this.fromUserId = fromUserId;
	}

	public int getToUserId() {
		return toUserId;
	}

	public void setToUserId(int toUserId) {
		this.toUserId = toUserId;
	}

	@Override
	public String toString() {
		return "Chatting [id=" + id + ", subject=" + subject + ", description=" + description + ", fromUserId="
				+ fromUserId + ", toUserId=" + toUserId + "]";
	}

}
