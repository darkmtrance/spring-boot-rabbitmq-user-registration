package com.mtomaylla.ms_user.controller;

import com.mtomaylla.ms_user.entity.User;
import com.mtomaylla.ms_user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserCreatedEventController {


    private UserService userService;
    @PostMapping("/user-event")
    public ResponseEntity<User> createUserEvent(@RequestBody User user) {
        User userSaved = userService.registerUser(user);
        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }

}