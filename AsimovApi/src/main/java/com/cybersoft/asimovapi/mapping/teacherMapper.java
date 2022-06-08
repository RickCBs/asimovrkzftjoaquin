package com.cybersoft.asimovapi.mapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cybersoft.asimovapi.domain.model.Teacher;
import com.cybersoft.asimovapi.resource.SaveTeacherResource;
import com.cybersoft.asimovapi.resource.TeacherResource;
import com.cybersoft.shared.mapping.EnhancedModelMapper;

public class teacherMapper {
    
    @Autowired
    EnhancedModelMapper mapper;

    public TeacherResource toResource(Teacher model){
        return mapper.map(model,TeacherResource.class);
    }

    public List<TeacherResource> modelListToResource(List<Teacher> modelList){
        return mapper.mapList(modelList, TeacherResource.class);
    }

    public Teacher toModel(SaveTeacherResource resource) {
        return mapper.map(resource, Teacher.class);
    }
}
