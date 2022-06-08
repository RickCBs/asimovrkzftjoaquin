package com.cybersoft.asimovapi.course.resource;

import lombok.Data;

@Data
public class CourseResource {
    private Long id;
    private String name;
    private String description;
    private boolean state;
}
