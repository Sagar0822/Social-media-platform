package com.MockSpring2.Social.media.platform.Controller;

import com.MockSpring2.Social.media.platform.DTOS.UserDtos;
import com.MockSpring2.Social.media.platform.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserDtos userDtos;

    @PostMapping("/add-user")
    public ResponseEntity<String> addUser(UserDtos userDtos){
        userService.addUser(userDtos);
        return new ResponseEntity<>("User added", HttpStatus.OK);
    }
}
