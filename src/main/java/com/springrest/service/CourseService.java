package com.springrest.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.entities.Course;


public interface CourseService extends JpaRepository<Course, Long>{

	public List<Course> getCourses();
	public Course getCourse(long courseId);
	public Course addCourse(Course courseId);
	public Course getCourse(Course courseId);
		
	
}
