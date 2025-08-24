package com.codingShuttle.LinkedIn.posts_service.Services.impl;

import com.codingShuttle.LinkedIn.posts_service.DTO.PostCreationDTO;
import com.codingShuttle.LinkedIn.posts_service.DTO.PostResponseDTO;
import com.codingShuttle.LinkedIn.posts_service.Repository.PostRepository;
import com.codingShuttle.LinkedIn.posts_service.Services.postservice;
import com.codingShuttle.LinkedIn.posts_service.entity.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements postservice {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public PostResponseDTO createPost(PostCreationDTO postCreationDTO, Long userId) {
        Post post = modelMapper.map(postCreationDTO , Post.class);
        post.setUserId(userId);

        Post savedPost = postRepository.save(post);
        return modelMapper.map(savedPost , PostResponseDTO.class);
    }

    @Override
    public List<PostResponseDTO> getAllMyPost(Long userId) {
        boolean exists = postRepository.existsById(userId);
        if(!exists){
            Post p = Post.builder().content("No posts made yet by user").build();
            List<PostResponseDTO> lp = new ArrayList<>();
            lp.add( modelMapper.map( p , PostResponseDTO.class));
            return lp;
        }
        return postRepository.findAllByUserId(userId).stream().map(
                post -> modelMapper.map(post, PostResponseDTO.class)
        ).toList();
    }
}
