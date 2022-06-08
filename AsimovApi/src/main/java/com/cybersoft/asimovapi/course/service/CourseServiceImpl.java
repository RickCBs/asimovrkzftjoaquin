package com.cybersoft.asimovapi.course.service;

import com.cybersoft.asimovapi.course.domain.repository.CourseRepository;
import com.cybersoft.asimovapi.course.domain.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cybersoft.asimovapi.course.domain.model.Course;
import com.cybersoft.shared.exception.ResourceNotFoundException;
import com.cybersoft.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.util.List;
import java.util.Set;


@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    
    private static final String ENTITY = "Course";
    private final Validator validator;

    public CourseServiceImpl(CourseRepository courseRepository, Validator validator) {
        this.courseRepository = courseRepository;
        this.validator = validator;
    }

    @Override
    public List<Course> getAllPosts() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId).orElseThrow(
            () -> new ResourceNotFoundException(ENTITY, courseId)
        );
    }

    @Override
    public Course createCourse(Course course) {
        Set<ConstraintViolation<Course>> violations  = validator.validate(course);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long courseId, Course course) {
        Set<ConstraintViolation<Course>> violations  = validator.validate(course);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return courseRepository.findById(courseId).map(courseP -> courseRepository.save(courseP))
        .orElseThrow(() -> new ResourceNotFoundException(ENTITY, courseId));
    }

    @Override
    public ResponseEntity<?> deleteCourse(Long courseId) {
        return courseRepository.findById(courseId).map(courseP -> {
            courseRepository.delete(courseP);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, courseId));
    }
}
