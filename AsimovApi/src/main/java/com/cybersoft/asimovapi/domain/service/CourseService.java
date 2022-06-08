package com.cybersoft.asimovapi.domain.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cybersoft.asimovapi.domain.model.Course;

@Service
public interface CourseService {
    //CRUD
    List<Course> getAllPosts();
    Course getCourseById(Long courseId);
    Course createCourse(Course course);
    Course updateCourse(Long courseId, Course course);
    ResponseEntity<?> deleteCourse(Long courseId);
}
