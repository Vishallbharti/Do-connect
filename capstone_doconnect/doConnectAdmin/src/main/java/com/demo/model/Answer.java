package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "answer")
public class Answer {
	/**
	 * @see this model class for answer, I decalared all required attributes and
	 *      Their getter setter.
	 * @author Vishal bharti
	 * @since 03-Jan-2022
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ans_id;
	private String description;
	private String img_url;
	private int user_id;
	private int approval;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "question_que_id")
	private Question question;

	public Answer() {
		super();
	}

	public Answer(String description, String img_url, int user_id, int approval, Question question) {
		super();
		this.description = description;
		this.img_url = img_url;
		this.user_id = user_id;
		this.approval = approval;
		this.question = question;
	}

	public Answer(String description, int user_id, int approval, Question question) {
		super();
		this.description = description;
		this.user_id = user_id;
		this.approval = approval;
		this.question = question;
	}

	public Answer(int ans_id, String description, String img_url, int user_id, int approval, Question question) {
		super();
		this.ans_id = ans_id;
		this.description = description;
		this.img_url = img_url;
		this.user_id = user_id;
		this.approval = approval;
		this.question = question;
	}

	public int getAns_id() {
		return ans_id;
	}

	public void setAns_id(int ans_id) {
		this.ans_id = ans_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getApproval() {
		return approval;
	}

	public void setApproval(int approval) {
		this.approval = approval;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answer [ans_id=" + ans_id + ", description=" + description + ", img_url=" + img_url + ", user_id="
				+ user_id + ", approval=" + approval + ", question=" + question + "]";
	}

}
