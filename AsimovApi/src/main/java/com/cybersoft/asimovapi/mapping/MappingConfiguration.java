package com.cybersoft.asimovapi.mapping;

import com.cybersoft.asimovapi.resource.SaveTeacherResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("asimovapiConfiguration")
public class MappingConfiguration {
    @Bean
    public SaveTeacherResource toModel(){
        return new SaveTeacherResource();
    }
}
