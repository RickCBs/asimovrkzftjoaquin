package com.cybersoft.asimovapi.domain.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cybersoft.asimovapi.domain.model.Teacher;

@Service
public interface TeacherService {
    List<Teacher> getAllPosts();

    Teacher getTeacherById(long teacherId);

    Teacher createTeacher(Teacher teacher);

    Teacher UpdateTeacher(long teacherId, Teacher teacher);

    ResponseEntity<?> deleteTeacher(long teacherId);
}

