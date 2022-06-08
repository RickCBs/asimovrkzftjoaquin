package com.cybersoft.asimovapi.teacher.domain.service;

import java.util.List;

import com.cybersoft.asimovapi.teacher.domain.model.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface TeacherService {
    List<Teacher> getAllPosts();

    Teacher getTeacherById(long teacherId);

    Teacher createTeacher(Teacher teacher);

    Teacher updateTeacher(long teacherId, Teacher teacher);

    ResponseEntity<?> deleteTeacher(long teacherId);
}

