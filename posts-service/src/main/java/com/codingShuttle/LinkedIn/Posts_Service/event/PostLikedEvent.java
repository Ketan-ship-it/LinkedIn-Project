package com.codingShuttle.LinkedIn.Posts_Service.event;

import lombok.Data;

@Data
public class PostLikedEvent {
    Long postId;
    Long userId;
    Long creatorId;
}
