package com.ga.Todo.controller;


import com.ga.Todo.model.User;
import com.ga.Todo.model.request.LoginRequest;
import com.ga.Todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User createUser(@RequestBody User userobject){
        System.out.println("calling createuser ==>");
        return userService.createUser(userobject);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        System.out.println("Calling LoginUser ==>");
        return userService.loginUser(loginRequest);
    }
}
