package com.cybersoft.asimovapi.domain.model;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "teacher")
public class Teacher{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @NotBlank
    private int point;

    @NotNull
    @NotBlank
    private String first_name;

    @NotNull
    @NotBlank
    private String last_name;

    @NotNull
    @NotBlank
    private int age;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String phone;

    //Relationships
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE},
    mappedBy = "teachers")
    private List<Course> courses;

}
