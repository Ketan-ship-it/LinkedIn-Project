package com.codingShuttle.LinkedIn.posts_service.Services;

import com.codingShuttle.LinkedIn.posts_service.DTO.PostCreationDTO;
import com.codingShuttle.LinkedIn.posts_service.DTO.PostResponseDTO;

import java.util.List;

public interface postservice {

    PostResponseDTO createPost(PostCreationDTO postCreationDTO);

    List<PostResponseDTO> getAllMyPost();
}
