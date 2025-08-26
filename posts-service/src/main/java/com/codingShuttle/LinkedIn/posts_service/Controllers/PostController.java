package com.codingShuttle.LinkedIn.posts_service.Controllers;

import com.codingShuttle.LinkedIn.posts_service.DTO.PostCreationDTO;
import com.codingShuttle.LinkedIn.posts_service.DTO.PostResponseDTO;
import com.codingShuttle.LinkedIn.posts_service.Services.impl.PostServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
public class PostController {

    private final PostServiceImpl postService;

    @PostMapping("/createPost")
    public ResponseEntity<PostResponseDTO> createPost(@RequestBody PostCreationDTO postCreationDTO , HttpServletRequest httpServletRequest){
        PostResponseDTO responseDTO = postService.createPost(postCreationDTO );
        return new ResponseEntity<>(responseDTO , HttpStatus.CREATED);
    }

    @GetMapping("/allPosts")
    public ResponseEntity<List<PostResponseDTO>> getAllMyPosts(){
        return ResponseEntity.ok(postService.getAllMyPost());
    }
}
