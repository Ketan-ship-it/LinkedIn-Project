package com.codingShuttle.LinkedIn.posts_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper madelMapper(){
        return new ModelMapper();
    }

}
