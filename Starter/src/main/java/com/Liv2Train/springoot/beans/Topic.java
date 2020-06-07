package com.Liv2Train.springoot.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Topic {
	
//	@Min(  message="Minimum 4 length required", value = 7)
	@Id
	private String id;
	
	
	private long mobile;
	
	@Email(message="Enter Valid email.")
	private String email;
	
//	@Email
//	@Pattern(regexp="^[a-zA-Z0-9]{3}",message="length must be 3")
//	@Size(min = 9, max = 15)
//	@Min(value=10,message = "stringValue has to be present")
	@Size(min = 9, max = 14,message = "Size has to be met")
	private String name;
	
	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	private String description;
	
	@CreationTimestamp
    private LocalDateTime createDateTime;
	@Transient private List<Course> courses=new ArrayList<>();
	public Topic() {
		
	}
	
	public Topic(String id, String name, String description, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email=email;
		this.description = description;
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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
	

}
