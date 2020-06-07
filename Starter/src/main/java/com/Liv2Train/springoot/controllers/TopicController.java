package com.Liv2Train.springoot.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Liv2Train.springoot.beans.Topic;
import com.Liv2Train.springoot.services.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService; 
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/topics/{id}")
	public Topic getTopic(@PathVariable("id") String id) {
		return topicService.getTopic(id);
	}
//	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@Valid @RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable("id") String id) {
		topicService.updateTopic(id,topic);
	}
	
//	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
//	public void deleteTopic(@PathVariable("id") String id) {
////		courseRepository.deleteByTopicId(id);
////		courseService.deleteCourse(courseId, id);
//		topicService.deleteTopic(id);
//	}

}






