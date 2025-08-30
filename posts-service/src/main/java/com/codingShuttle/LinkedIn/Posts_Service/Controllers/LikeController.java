package com.codingShuttle.LinkedIn.Posts_Service.Controllers;

import com.codingShuttle.LinkedIn.Posts_Service.Services.impl.LikeServiceImpl;
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
        likeService.likePost(postId );
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/del/{postId}")
    public ResponseEntity<Void> unlikePost(@PathVariable Long postId , HttpServletRequest httpServletRequest){
        likeService.unlikePost(postId );
        return ResponseEntity.noContent().build();
    }

}
