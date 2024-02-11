package com.demo.model;

public class ResponsePage {
	/**
	 * @see This model class is represnting the message data type and their getter
	 *      setter.
	 * @author Vishal bharti
	 * @since 03-Jan-2022
	 */
	private Messages message;
	private String description;

	public ResponsePage() {
		// TODO Auto-generated constructor stub
	}

	public ResponsePage(Messages message, String description) {
		super();
		this.message = message;
		this.description = description;
	}

	public Messages getMessage() {
		return message;
	}

	public void setMessage(Messages message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ResponsePage [message=" + message + ", description=" + description + "]";
	}

}
