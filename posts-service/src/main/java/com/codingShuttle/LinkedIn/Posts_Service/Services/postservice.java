package com.codingShuttle.LinkedIn.Posts_Service.Services;

import com.codingShuttle.LinkedIn.Posts_Service.DTO.PostCreationDTO;
import com.codingShuttle.LinkedIn.Posts_Service.DTO.PostResponseDTO;

import java.util.List;

public interface postservice {

    PostResponseDTO createPost(PostCreationDTO postCreationDTO);

    List<PostResponseDTO> getAllMyPost();
}
