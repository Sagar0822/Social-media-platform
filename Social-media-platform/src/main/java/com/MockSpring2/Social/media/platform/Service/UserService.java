package com.MockSpring2.Social.media.platform.Service;

import com.MockSpring2.Social.media.platform.DTOS.UserRequestDtos;
import com.MockSpring2.Social.media.platform.Models.Post;
import com.MockSpring2.Social.media.platform.Models.User;
import com.MockSpring2.Social.media.platform.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(UserRequestDtos userRequestDtos){
        User user = User.builder()
                .name(userRequestDtos.getName())
                .age(userRequestDtos.getAge())
                .build();

        userRepository.save(user);
    }
    public User getUserMostLikes(){
        User user = null;
        List<User> userList = userRepository.findAll();
        int countLikes = 0;
        int maxLikes = 0;
        for(User users : userList){
            for(Post posts : users.getPosts()){
                countLikes += posts.getLike();
            }
            if(maxLikes < countLikes){
                user = users;
            }
            maxLikes = Math.max(maxLikes, countLikes);
        }
          return user;
    }
}
