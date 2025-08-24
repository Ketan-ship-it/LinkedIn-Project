package com.codingShuttle.LinkedIn.posts_service.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class PostResponseDTO {
    private Long postId;
    private Long userId;
    private String content;
    private LocalDateTime createdAt;
}

