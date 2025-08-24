package com.codingShuttle.LinkedIn.posts_service.Repository;

import com.codingShuttle.LinkedIn.posts_service.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post , Long> {

    List<Post> findAllByUserId(Long userId);

}
