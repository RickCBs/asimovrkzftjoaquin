package com.cybersoft.asimovapi.teacher.resource;

import lombok.Data;

@Data
public class TeacherResource {
    private long id;
    
    private int point;

    private String first_name;

    private String last_name;

    private int age;

    private String email;

    private String phone;
}
