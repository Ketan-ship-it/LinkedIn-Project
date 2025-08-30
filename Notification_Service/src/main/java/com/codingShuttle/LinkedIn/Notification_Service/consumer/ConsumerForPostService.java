package com.codingShuttle.LinkedIn.Notification_Service.consumer;

import com.codingShuttle.LinkedIn.Notification_Service.DTO.PersonDTO;
import com.codingShuttle.LinkedIn.Notification_Service.feignClients.ConnectionClient;
import com.codingShuttle.LinkedIn.Notification_Service.service.NotificationService;
import com.codingShuttle.LinkedIn.Posts_Service.event.PostCreatedEvent;
import com.codingShuttle.LinkedIn.Posts_Service.event.PostLikedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerForPostService {

    private final NotificationService notificationService;
    private final ConnectionClient connectionClient;

//    @KafkaListener(topics = "created-post-topic" )
//    public void handlePostCreatedEvent(PostCreatedEvent postCreatedEvent){
//        log.info("Inside PostCreatedEvent");
//        List<PersonDTO> firstdegreeconnections = connectionClient.getFirstDegreeConnections(postCreatedEvent.getCreatorId()).getBody();
//        log.info("Fetching Connections");
//        if (firstdegreeconnections != null) {
//            for (PersonDTO person : firstdegreeconnections) {
//                log.info("Sending Message to each connection");
//                String message = "Your connection with id "+postCreatedEvent.getCreatorId() + "has made a post with id"+postCreatedEvent.getPostId();
//                notificationService.send(person.getUserId() , message);
//            }
//        }
//
//    }
//
//    @KafkaListener( topics = "liked-post-topic" )
//    public void handlePostCreatedEvent(PostLikedEvent postLikedEvent){
//        String message = "Your connection with id "+ postLikedEvent.getUserId() + "has made a post";
//        notificationService.send(postLikedEvent.getCreatorId() , message);
//    }
    @KafkaListener(topics = "created-post-topic")
    public void handlePostCreated(PostCreatedEvent postCreatedEvent) {
        log.info("Sending notifications: handlePostCreated: {}", postCreatedEvent);
        List<PersonDTO> connections = connectionClient.getFirstDegreeConnections(postCreatedEvent.getCreatorId());

        for(PersonDTO connection: connections) {
            notificationService.send(connection.getUserId(), "Your connection "+postCreatedEvent.getCreatorId()+" has created" +
                    " a post, Check it out");
        }
    }

    @KafkaListener(topics = "liked-post-topic")
    public void handlePostLiked(PostLikedEvent postLikedEvent) {
        log.info("Sending notifications: handlePostLiked: {}", postLikedEvent);
        String message = String.format("Your post, %d has been liked by %d", postLikedEvent.getPostId(),
                postLikedEvent.getUserId());

        notificationService.send(postLikedEvent.getCreatorId(), message);
    }
}
