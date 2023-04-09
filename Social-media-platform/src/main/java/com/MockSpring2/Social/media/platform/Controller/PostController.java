package com.MockSpring2.Social.media.platform.Controller;

import com.MockSpring2.Social.media.platform.DTOS.PostRequestDto;
import com.MockSpring2.Social.media.platform.Models.Notification;
import com.MockSpring2.Social.media.platform.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//https://pastebin.com/iPsEkWmG
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostRequestDto postRequestDto;

    @Autowired
    PostService postService;


    @PostMapping("/add-post")
    public ResponseEntity<String> addPost(@RequestBody PostRequestDto postRequestDto) throws Exception{
        try {
            postService.addPost(postRequestDto);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("post added", HttpStatus.OK);
    }
    @PutMapping("like-post")
    public void likePost(@RequestParam("/userId") int userId, @RequestParam("/postId") int postId) throws Exception{
        postService.likePost(userId,postId);
    }
    @PostMapping("/send-notification")
    public List<Notification> sendNotification(@RequestParam("/userId") int userId){
        return postService.sendNotification(userId);
    }
}
