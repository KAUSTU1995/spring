package com.Liv2Train.springoot.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Liv2Train.springoot.beans.Course;
import com.Liv2Train.springoot.beans.Topic;
import com.Liv2Train.springoot.dao.CourseRepository;
import com.Liv2Train.springoot.dao.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
//	private List<Topic> topics=new ArrayList<>(Arrays.asList(
//			new Topic(  "Spring","Spring framework", "Spring Description"),
//			new Topic("Java","Core java", "core java Description"),
//			new Topic("Javascript","Javascript","Javascript description")
//			));
	
	public List<Topic> getAllTopics(){
//		return topics;
//		return (List<Topic>) topicRepository.findAll();
		List<Topic> topics=new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		for(Topic topic:topics) {
			topic.setCourses(courseRepository.findByTopicId(topic.getId()));
		}
		return topics;
	}
	
	public Topic getTopic(String id) {
//		return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
		Topic topic = topicRepository.findById(id).get();
		List<Course> courses=courseRepository.findByTopicId(topic.getId());
		topic.setCourses(courses);
		return topic;
	}
	
	public void addTopic(Topic topic) {
//		topics.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {

//		for(int i=0;i<topics.size();i++) {
//			if(topics.get(i).getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {

//		topics.removeIf(t->t.getId().equals(id));
		topicRepository.deleteById(id);
	}

}
