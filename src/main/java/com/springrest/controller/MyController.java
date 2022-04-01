package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entities.Course;
import com.springrest.service.CourseService;

@RestController
//@RequestMapping("/api/courses")
public class MyController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("home")	
	public String home(){
		System.out.println("Home");
		return "Welcome to rest API First a";
	}
	//Get the courses
	@GetMapping("courses")
	public List<Course> getCourses(){
		
		return this.courseService.getCourses();
		
	}
	
	@GetMapping("courses/{courseId}")
	public Course getCourse(@PathVariable String courseId ) {
		
	return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/api/courses")
	public ResponseEntity<Course> addCourse(@RequestBody Course course){
		
		return new ResponseEntity<Course>(courseService.addCourse(course), HttpStatus.CREATED);
		
		
	}
		
	@GetMapping("/api/courses")
	public ResponseEntity<Course> getCourse(@RequestBody Course course){
		
		return new ResponseEntity<Course>(courseService.getCourse(course), HttpStatus.CREATED);
		
		
	}	
}
