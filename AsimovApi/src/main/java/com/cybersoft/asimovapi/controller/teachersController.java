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

import com.cybersoft.asimovapi.domain.service.TeacherService;
import com.cybersoft.asimovapi.mapping.teacherMapper;
import com.cybersoft.asimovapi.resource.SaveTeacherResource;
import com.cybersoft.asimovapi.resource.TeacherResource;

@RestController
@RequestMapping("/api/v1/teachers")
public class teachersController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
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
