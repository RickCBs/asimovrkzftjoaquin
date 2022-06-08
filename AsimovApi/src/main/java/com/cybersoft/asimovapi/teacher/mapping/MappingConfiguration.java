package com.cybersoft.asimovapi.teacher.mapping;

import com.cybersoft.asimovapi.teacher.resource.SaveTeacherResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("asimovApiConfiguration")
public class MappingConfiguration {
    @Bean
    public SaveTeacherResource toModel(){
        return new SaveTeacherResource();
    }
}
