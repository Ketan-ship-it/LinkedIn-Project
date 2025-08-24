package com.codingShuttle.LinkedIn.posts_service.Services;

import com.codingShuttle.LinkedIn.posts_service.DTO.PostCreationDTO;
import com.codingShuttle.LinkedIn.posts_service.DTO.PostResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface postservice {

    PostResponseDTO createPost(PostCreationDTO postCreationDTO , Long userId);

    List<PostResponseDTO> getAllMyPost(Long userId);
}
