package com.Liv2Train.springoot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Liv2Train.springoot.beans.Course;
import com.Liv2Train.springoot.beans.Topic;
import com.Liv2Train.springoot.dao.CourseRepository;
import com.Liv2Train.springoot.dao.TopicRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private TopicRepository topicRepository;
	
//	private List<Topic> topics=new ArrayList<>(Arrays.asList(
//			new Topic(  "Spring","Spring framework", "Spring Description"),
//			new Topic("Java","Core java", "core java Description"),
//			new Topic("Javascript","Javascript","Javascript description")
//			));
	
	public List<Course> getAllCourses(String topicId){
//		return topics;
//		return (List<Topic>) topicRepository.findAll();
		
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		
//		return courseRepository.findByTopicId(topicId);
		return courses;
	}
	
	public Course getCourse(String id) {
//		return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id).get();
	}
	
	public void addCourse(Course course , String topicId) {
//		topics.add(topic);
		Topic topic=topicRepository.findById(topicId).get();
		topic.getCourses().add(course);
		course.setTopic(topic);
		courseRepository.save(course);
	}

	public void updateCourse(Course course, String topicId) {

//		for(int i=0;i<topics.size();i++) {
//			if(topics.get(i).getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		Topic topic=topicRepository.findById(topicId).get();
//		topic.getCourses().contains(o)
		for(Course courseInList:topic.getCourses()) {
			if(courseInList.getId()==course.getId()) {
				courseInList=course;
			}
		}
		if(!topic.getCourses().contains(course)) {
			topic.getCourses().add(course);
			}
//		topic.getCourses().add(course);
		if(course.getTopic()==null)
		course.setTopic(topic);
//		course.setTopic(topicRepository.findById(topicId).get());
		courseRepository.save(course);
	}

	public void deleteCourse(String courseId, String topicId) {
		Topic topic=topicRepository.findById(topicId).get();
		for(Course course: topic.getCourses()) {
			if(course.getId()==courseId) {
				topic.getCourses().remove(course);
			}
		}

//		topics.removeIf(t->t.getId().equals(id));
		courseRepository.deleteById(courseId);
	}

}
