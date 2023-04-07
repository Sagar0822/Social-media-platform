package com.MockSpring2.Social.media.platform.Service;

import com.MockSpring2.Social.media.platform.DTOS.PostDto;
import com.MockSpring2.Social.media.platform.Models.Post;
import com.MockSpring2.Social.media.platform.Models.User;
import com.MockSpring2.Social.media.platform.Repository.PostRepository;
import com.MockSpring2.Social.media.platform.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostDto postDto;

    public void addPost(int userId, PostDto postDto) throws Exception {
        User user;
        try {
            user = userRepository.findById(userId).get();
        }
        catch(Exception e){
            throw new Exception("User Id not found");
        }
        Post post = Post.builder()
                .content(postDto.getContent())
                .like(0)
                .build();

       post.setUser(user);

       postRepository.save(post);
    }
}
