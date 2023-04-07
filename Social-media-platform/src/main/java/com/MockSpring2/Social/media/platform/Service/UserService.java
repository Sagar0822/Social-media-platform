package com.MockSpring2.Social.media.platform.Service;

import com.MockSpring2.Social.media.platform.DTOS.UserDtos;
import com.MockSpring2.Social.media.platform.Models.User;
import com.MockSpring2.Social.media.platform.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDtos userDtos;

    public void addUser(UserDtos userDtos){
        User user = User.builder()
                .name(userDtos.getName())
                .age(userDtos.getAge())
                .build();

        userRepository.save(user);
    }
}
