package com.codingShuttle.LinkedIn.posts_service.Controllers;

import com.codingShuttle.LinkedIn.posts_service.Services.impl.LikeServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
public class LikeController {

    private final LikeServiceImpl likeService;

    @PostMapping("/{postId}")
    public ResponseEntity<Void> likePost(@PathVariable Long postId , HttpServletRequest httpServletRequest){
        likeService.likePost(postId , 1L);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/del/{postId}")
    public ResponseEntity<Void> unlikePost(@PathVariable Long postId , HttpServletRequest httpServletRequest){
        likeService.unlikePost(postId , 1L);
        return ResponseEntity.noContent().build();
    }

}
