package com.cybersoft.asimovapi.resource;

import lombok.Data;

@Data
public class CourseResource {
    private Long id;
    private String name;
    private String description;
    private boolean state;
}
