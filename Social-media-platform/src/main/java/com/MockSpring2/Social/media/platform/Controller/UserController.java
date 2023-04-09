package com.MockSpring2.Social.media.platform.Controller;

import com.MockSpring2.Social.media.platform.DTOS.UserRequestDtos;
import com.MockSpring2.Social.media.platform.Models.User;
import com.MockSpring2.Social.media.platform.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRequestDtos userDtos;

    @PostMapping("/add-user")
    public ResponseEntity<String> addUser(@RequestBody UserRequestDtos userRequestDtos){
        userService.addUser(userRequestDtos);
        return new ResponseEntity<>("User added", HttpStatus.OK);
    }
    @GetMapping("/get-user")
    public User getUserMostLikes(){
        return userService.getUserMostLikes();
    }
}
