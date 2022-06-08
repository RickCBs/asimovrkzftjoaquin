package com.cybersoft.asimovapi.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SaveTeacherResource {

    @NotNull
    @NotBlank
    private int point;

    @NotNull
    @NotBlank
    @Size(max = 20)
    private String first_name;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String last_name;

    @NotNull
    @NotBlank
    private int age;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String email;

    @NotNull
    @NotBlank
    private String phone;
}
