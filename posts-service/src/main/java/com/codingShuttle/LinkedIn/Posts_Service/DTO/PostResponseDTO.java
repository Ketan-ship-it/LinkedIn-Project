package com.codingShuttle.LinkedIn.Posts_Service.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResponseDTO {
    private Long postId;
    private Long userId;
    private String content;
    private LocalDateTime createdAt;
}

