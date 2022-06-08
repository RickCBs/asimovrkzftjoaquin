package com.cybersoft.asimovapi.service;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cybersoft.asimovapi.domain.model.Teacher;
import com.cybersoft.asimovapi.domain.service.TeacherService;

@Service
public class CourseServiceImpl implements TeacherService{

    @Override
    public Teacher UpdateTeacher(long teacherId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Teacher createTeacher(long teacherId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<?> deleteTeacher(long teacherId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Teacher> getAllPosts(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Teacher getTeacherById(long teacherId) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
