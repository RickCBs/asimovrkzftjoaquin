package com.cybersoft.asimovapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybersoft.asimovapi.domain.service.CourseService;
import com.cybersoft.asimovapi.mapping.courseMapper;
import com.cybersoft.asimovapi.resource.CourseResource;
import com.cybersoft.asimovapi.resource.SaveCourseResource;

@RestController
@RequestMapping("/api/v1/courses")
public class coursesController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private courseMapper mapper;

    @GetMapping
    public List<CourseResource> getAllCourse() {
        return mapper.modelListToResource(courseService.getAllPosts());
    } 

    @GetMapping("{courseId}")
    public CourseResource getCourseById(@PathVariable("courseId") Long courseId) {
        return mapper.toResource(courseService.getCourseById(courseId));
    }

    @PostMapping
    public CourseResource createCourse(@RequestBody SaveCourseResource resource) {
        return mapper.toResource(courseService.createCourse(mapper.toModel(resource)));
    } 

    @PutMapping("{courseId}")
    public CourseResource updateCourse(@PathVariable("courseId") Long courseId, @RequestBody SaveCourseResource resource) {
        return mapper.toResource(courseService.updateCourse(courseId, mapper.toModel(resource)));
    }

    @DeleteMapping("{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable("courseId") Long courseId) {
        return courseService.deleteCourse(courseId);
    }

}
