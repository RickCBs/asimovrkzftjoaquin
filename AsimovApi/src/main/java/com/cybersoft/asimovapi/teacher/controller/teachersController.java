package com.cybersoft.asimovapi.teacher.controller;

import java.util.List;

import com.cybersoft.asimovapi.teacher.resource.SaveTeacherResource;
import com.cybersoft.asimovapi.teacher.resource.TeacherResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybersoft.asimovapi.teacher.domain.service.TeacherService;
import com.cybersoft.asimovapi.teacher.mapping.teacherMapper;

@RestController
@RequestMapping("/api/v1/teachers")
public class teachersController {

    private TeacherService teacherService;

    private teacherMapper mapper;

    @GetMapping()
    public List<TeacherResource> getAllTeacher(){
        return mapper.modelListToResource(teacherService.getAllPosts());
    }

    @GetMapping("{teacherId}")
    public TeacherResource getTeacherById(@PathVariable("teacherId")Long teacherId){
        return mapper.toResource(teacherService.getTeacherById(teacherId));
    }

    @PostMapping() 
    public TeacherResource createTeacher(@RequestBody SaveTeacherResource resource){
        return mapper.toResource(teacherService.createTeacher(mapper.toModel(resource)));
    }

    @PutMapping("{teacherId}")
    public TeacherResource updateTeacher(@PathVariable("teacherId") Long courseId, @RequestBody SaveTeacherResource resource){
        return mapper.toResource(teacherService.updateTeacher(courseId, mapper.toModel(resource)));
    }

    @DeleteMapping("{teacherId}")
    public ResponseEntity<?> deleteTeacher(@PathVariable("teacherId") Long teacherId){
        return teacherService.deleteTeacher(teacherId);
    }
}
