package com.Liv2Train.springoot.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Liv2Train.springoot.beans.Course;

public interface CourseRepository extends CrudRepository<Course,String>{
	
	public List<Course> findByTopicId(String topicId);
	public long deleteByTopicId(String topicId);
	

}
