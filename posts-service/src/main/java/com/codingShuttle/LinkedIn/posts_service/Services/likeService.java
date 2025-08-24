package com.codingShuttle.LinkedIn.posts_service.Services;

public interface likeService {

    void likePost (Long postId , Long userId);

    void unlikePost(Long postId, Long userId);
}
