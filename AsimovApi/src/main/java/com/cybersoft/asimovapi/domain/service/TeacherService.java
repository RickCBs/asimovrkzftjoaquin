package com.cybersoft.asimovapi.domain.service;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cybersoft.asimovapi.domain.model.Teacher;

@Service
public interface TeacherService {
    Page<Teacher> getAllPosts(Pageable pageable);

    Teacher getTeacherById(long teacherId);

    Teacher createTeacher(long teacherId);

    Teacher UpdateTeacher(long teacherId);

    ResponseEntity<?> deleteTeacher(long teacherId);
}

