package com.codingShuttle.LinkedIn.Posts_Service.Repository;

import com.codingShuttle.LinkedIn.Posts_Service.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post , Long> {

    List<Post> findAllByUserId(Long userId);

}
