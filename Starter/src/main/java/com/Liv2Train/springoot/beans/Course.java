package com.Liv2Train.springoot.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"topic"})
public class Course {
	
//	@Min(  message="Minimum 4 length required", value = 7)
	@Id
	private String id;
	
//	@Email
	private String name;
	private String description;
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	private Topic topic;
	
	public Course() {
		
	}
	
	public Course(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
//		this.setTopic(new TopicService().getTopic(topicId));
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	
	

}
