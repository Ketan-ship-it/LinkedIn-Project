package com.codingShuttle.LinkedIn.Posts_Service.Services.impl;

import com.codingShuttle.LinkedIn.Posts_Service.DTO.PostCreationDTO;
import com.codingShuttle.LinkedIn.Posts_Service.DTO.PostResponseDTO;
import com.codingShuttle.LinkedIn.Posts_Service.Repository.PostRepository;
import com.codingShuttle.LinkedIn.Posts_Service.Services.postservice;
import com.codingShuttle.LinkedIn.Posts_Service.auth.UserContextHolder;
import com.codingShuttle.LinkedIn.Posts_Service.entity.Post;
import com.codingShuttle.LinkedIn.Posts_Service.event.PostCreatedEvent;
import com.codingShuttle.LinkedIn.Posts_Service.feignClients.ConnectionClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements postservice {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final KafkaTemplate<Long , PostCreatedEvent> kafkaTemplate;
    private final ConnectionClient connectionClient;

    @Override
    public PostResponseDTO createPost(PostCreationDTO postCreationDTO) {
        Long userid = UserContextHolder.getCurrentUserId();
        Post post = modelMapper.map(postCreationDTO , Post.class);
        post.setUserId(userid);

        Post savedPost = postRepository.save(post);

        PostCreatedEvent newPost = new PostCreatedEvent();
        newPost.setCreatorId(userid);
        newPost.setContent(savedPost.getContent());
        newPost.setPostId(post.getId());
        kafkaTemplate.send("created-post-topic" , newPost);

        return modelMapper.map(savedPost , PostResponseDTO.class);
    }

    @Override
    public List<PostResponseDTO> getAllMyPost() {
        Long userid = UserContextHolder.getCurrentUserId();
//        List<PersonDTO> firstConnections = connectionClient.getFirstDegreeConnections().getBody();
        boolean exists = postRepository.existsById(userid);
        if(!exists){
            Post p = Post.builder().content("No posts made yet by user").build();
            List<PostResponseDTO> lp = new ArrayList<>();
            lp.add( modelMapper.map( p , PostResponseDTO.class));
            return lp;
        }
        return postRepository.findAllByUserId(userid).stream().map(
                post -> modelMapper.map(post, PostResponseDTO.class)
        ).toList();
    }
}
