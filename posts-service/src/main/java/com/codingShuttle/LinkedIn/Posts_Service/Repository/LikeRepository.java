package com.codingShuttle.LinkedIn.Posts_Service.Repository;

import com.codingShuttle.LinkedIn.Posts_Service.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<PostLike , Long> {

    List<PostLike> findByUserId(Long userId);

    boolean existsByPostIdAndUserId(Long postId, Long userId);

    @Transactional
    void deleteByPostIdAndUserId(Long postId, Long userId);
}
