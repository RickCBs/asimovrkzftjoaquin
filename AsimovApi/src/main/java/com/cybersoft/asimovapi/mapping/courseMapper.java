package com.cybersoft.asimovapi.mapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cybersoft.asimovapi.domain.model.Course;
import com.cybersoft.asimovapi.resource.CourseResource;
import com.cybersoft.asimovapi.resource.SaveCourseResource;
import com.cybersoft.shared.mapping.EnhancedModelMapper;

public class courseMapper {

    @Autowired
    EnhancedModelMapper mapper;

    public CourseResource toResource(Course model) {
        return mapper.map(model, CourseResource.class);
    }

    public List<CourseResource> modelListToResource(List<Course> modelList) {
        return mapper.mapList(modelList, CourseResource.class);
    }

    public Course toModel(SaveCourseResource resource) {
        return mapper.map(resource, Course.class);
    }
    
}
