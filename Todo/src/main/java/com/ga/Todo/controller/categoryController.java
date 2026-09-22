package com.ga.Todo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class categoryController {

    @GetMapping("/hello")
    public String hello(){
        return "hello world!";
    }
}
