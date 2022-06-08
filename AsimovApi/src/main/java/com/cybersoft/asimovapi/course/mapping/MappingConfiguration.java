package com.cybersoft.asimovapi.mapping;

import com.cybersoft.asimovapi.resource.SaveCourseResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("asimovApiConfiguration")
public class MappingConfiguration {
    @Bean
    public SaveCourseResource toModel() {
        return new SaveCourseResource();
    }
}
