package com.Liv2Train.springoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Liv2Train.springoot.beans.Course;
import com.Liv2Train.springoot.services.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService; 
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId) {
//		return courseService.getAllCourses();
		return courseService.getAllCourses(topicId);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable("courseId") String courseId) {
		return courseService.getCourse(courseId);
	}
//	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
//		course.setTopic(new TopicService().getTopic(topicId));
		courseService.addCourse(course,topicId);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable("courseId") String courseId) {
//		course.setTopic(new TopicService().getTopic(topicId));
		courseService.updateCourse(course,topicId);
	}
	
//	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}")
//	public void deleteCourse(@PathVariable("courseId") String courseId, @PathVariable("topicId") String topicId) {
//		courseService.deleteCourse(courseId, topicId);
//	}

}






