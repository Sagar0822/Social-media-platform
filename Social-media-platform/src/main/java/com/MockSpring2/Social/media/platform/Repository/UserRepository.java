package com.MockSpring2.Social.media.platform.Repository;

import com.MockSpring2.Social.media.platform.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends JpaRepository<User,Integer> {
}
