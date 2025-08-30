package com.codingShuttle.LinkedIn.Posts_Service.Services.impl;

import com.codingShuttle.LinkedIn.Posts_Service.Repository.LikeRepository;
import com.codingShuttle.LinkedIn.Posts_Service.Repository.PostRepository;
import com.codingShuttle.LinkedIn.Posts_Service.Services.likeService;
import com.codingShuttle.LinkedIn.Posts_Service.auth.UserContextHolder;
import com.codingShuttle.LinkedIn.Posts_Service.entity.Post;
import com.codingShuttle.LinkedIn.Posts_Service.entity.PostLike;
import com.codingShuttle.LinkedIn.Posts_Service.event.PostLikedEvent;
import com.codingShuttle.LinkedIn.Posts_Service.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class LikeServiceImpl implements likeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final KafkaTemplate<Long , PostLikedEvent> kafkaTemplate;

    @Override
    @Transactional
    public void likePost(Long postId) {
        Long userId = UserContextHolder.getCurrentUserId();
        log.info("Liking the post , postId : {} , userId :{}",postId , userId);
        boolean exists = postRepository.existsById(postId);
        if(!exists){
            log.info("No such post , postId : {} , userId :{}",postId , userId);
            throw new BadRequestException("No such post");
        }
        boolean alreadyLiked = likeRepository.existsByPostIdAndUserId(postId , userId);
        if(alreadyLiked) {
            log.info("Post already liked , postId : {} , userId :{}",postId , userId);
            throw new BadRequestException("Post already liked ");
        }
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new RuntimeException("Post not found with id: " + postId)
        );
        PostLike like = PostLike.builder()
                .postId(postId)
                .userId(userId)
                .build();
        likeRepository.save(like);

        PostLikedEvent likedEvent = new PostLikedEvent();
        likedEvent.setPostId(postId);
        likedEvent.setUserId(userId);
        likedEvent.setCreatorId(post.getUserId());
        kafkaTemplate.send("liked-post-topic" , likedEvent);

        log.info("Post liked , postId : {} , userId :{}",postId , userId);

    }

    @Override
    public void unlikePost(Long postId) {
        Long userId = UserContextHolder.getCurrentUserId();
        log.info("UnLiking the post , postId : {} , userId :{}",postId , userId);
        boolean exists = postRepository.existsById(postId);
        if(!exists){
            throw new RuntimeException("No such post or post deleted");
        }
        boolean alreadyLiked = likeRepository.existsByPostIdAndUserId(postId , userId);
        if(!alreadyLiked) {
            log.info("Cannot unlike post which is not liked , postId : {} , userId :{}",postId , userId);
            throw new BadRequestException("Cannot unlike post which is not liked ");
        }

        likeRepository.deleteByPostIdAndUserId(postId , userId);
        log.info("Post unliked , postId : {} , userId :{}",postId , userId);
    }
}
