package com.MockSpring2.Social.media.platform.Service;

import com.MockSpring2.Social.media.platform.DTOS.PostRequestDto;
import com.MockSpring2.Social.media.platform.Models.Notification;
import com.MockSpring2.Social.media.platform.Models.Post;
import com.MockSpring2.Social.media.platform.Models.User;
import com.MockSpring2.Social.media.platform.Repository.PostRepository;
import com.MockSpring2.Social.media.platform.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public void addPost(PostRequestDto postRequestDto) throws Exception {
        User user;
        try {
            user = userRepository.findById(postRequestDto.getUserId()).get();
        }
        catch(Exception e){
            throw new Exception("User Id not found");
        }
        Post post = Post.builder()
                .content(postRequestDto.getContent())
                .like(0)
                .build();

       post.setUser(user);
       user.getPosts().add(post);
       userRepository.save(user);
    }
    public void likePost(int userId, int postId) throws Exception{
       User user;
       try {
           user = userRepository.findById(userId).get();
       }
       catch(Exception e){
           throw new Exception("UserId not valid");
       }
       List<Post> posts = user.getPosts();
       for(Post post : posts){
           if(post.getPostId() == postId){
               int previousLike = post.getLike();
               post.setLike(previousLike + 1);

               Notification notification = new Notification();
               notification.setPost(post);
               user.getUserNotifications().add(notification);
           }
       }
        userRepository.save(user);
    }
    public List<Notification> sendNotification(int userId){
        User user = userRepository.findById(userId).get();

        List<Notification> notificationList = user.getUserNotifications();
        return notificationList;
    }
}
