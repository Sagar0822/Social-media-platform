package com.MockSpring2.Social.media.platform.Controller;

import com.MockSpring2.Social.media.platform.DTOS.PostDto;
import com.MockSpring2.Social.media.platform.Models.User;
import com.MockSpring2.Social.media.platform.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostDto postDto;

    @Autowired
    PostService postService;

    @PostMapping("/add-post")
    public ResponseEntity<String> addPost(int userId, PostDto postDto) throws Exception{
        try {
            postService.addPost(userId, postDto);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("post added", HttpStatus.OK);
    }
}
