package com.ga.Todo.controller;


import com.ga.Todo.model.Category;
import com.ga.Todo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class categoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    private void setCategoryService(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello world!";
    }


    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/categories/{id}")
    public Optional<Category> getCategory(@PathVariable Long id){
        return categoryService.getCategory(id);
    }

}
