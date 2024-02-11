package com.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Question {
	/**
	 * @see this model class is representing the data of quesion and their getter
	 *      setter
	 * @author Vishal Bharti
	 * @since 03-Jan-2022
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int que_id;
	private String topic;
	private String description;
	private String img_url;
	private int user_id;
	private int approval;

	@JsonManagedReference
	@OneToMany(mappedBy = "question")
	private List<Answer> answers;

	public Question() {

	}

	public Question(String topic, String description, String img_url, int user_id, int approval, List<Answer> answers) {
		super();
		this.topic = topic;
		this.description = description;
		this.img_url = img_url;
		this.user_id = user_id;
		this.approval = approval;
		this.answers = answers;
	}

	public Question(String topic, String description, int user_id, int approval, List<Answer> answers) {
		super();
		this.topic = topic;
		this.description = description;
		this.user_id = user_id;
		this.approval = approval;
		this.answers = answers;
	}

	public Question(int que_id, String topic, String description, String img_url, int user_id, int approval,
			List<Answer> answers) {
		super();
		this.que_id = que_id;
		this.topic = topic;
		this.description = description;
		this.img_url = img_url;
		this.user_id = user_id;
		this.approval = approval;
		this.answers = answers;
	}

	public int getQue_id() {
		return que_id;
	}

	public void setQue_id(int que_id) {
		this.que_id = que_id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
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

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question [que_id=" + que_id + ", topic=" + topic + ", description=" + description + ", img_url="
				+ img_url + ", user_id=" + user_id + ", approval=" + approval + ", answers=" + answers + "]";
	}

}
