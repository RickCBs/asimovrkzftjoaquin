package com.cybersoft.asimovapi.service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cybersoft.asimovapi.domain.model.Teacher;
import com.cybersoft.asimovapi.domain.repository.TeacherRepository;
import com.cybersoft.asimovapi.domain.service.TeacherService;
import com.cybersoft.shared.exception.ResourceNotFoundException;
import com.cybersoft.shared.exception.ResourceValidationException;


@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private final Validator validator;

    private static final String ENTITY = "Teacher";

    public TeacherServiceImpl(TeacherRepository teacherRepository, Validator validator) {
        this.teacherRepository = teacherRepository;
        this.validator = validator;
    }

    @Override
    public Teacher updateTeacher(long teacherId, Teacher teacher) {
        Set<ConstraintViolation<Teacher>> violations = validator.validate(teacher);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        
        return teacherRepository.findById(teacherId).map(
            teacherP -> teacherRepository.save(teacherP)
        ).orElseThrow(
            () -> new ResourceNotFoundException(ENTITY, teacherId)
        );
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        Set<ConstraintViolation<Teacher>> violations = validator.validate(teacher);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        
        return teacherRepository.save(teacher);
    }

    @Override
    public ResponseEntity<?> deleteTeacher(long teacherId) {
        return teacherRepository.findById(teacherId).map( teacherP -> {
            teacherRepository.delete(teacherP);
            return ResponseEntity.ok().build();
        })
        .orElseThrow(() -> new ResourceNotFoundException(ENTITY, teacherId));
    }

    @Override
    public List<Teacher> getAllPosts() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(long teacherId) {
        return teacherRepository.findById(teacherId).orElseThrow(
            ()-> new ResourceNotFoundException(ENTITY, teacherId)
        );
    }
    
}
