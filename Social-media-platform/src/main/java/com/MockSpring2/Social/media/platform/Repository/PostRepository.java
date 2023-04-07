package com.MockSpring2.Social.media.platform.Repository;

import com.MockSpring2.Social.media.platform.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,String> {
}
