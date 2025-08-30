package com.codingShuttle.LinkedIn.Posts_Service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic createdPostTopic(){
        return new NewTopic("created-post-topic" , 3 , (short)1);
    }

    @Bean
    public NewTopic likePostTopic(){
        return new NewTopic("liked-post-topic" , 3 , (short)1);
    }

}
