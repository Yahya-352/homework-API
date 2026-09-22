package com.ga.Todo.controller;


import com.ga.Todo.model.Category;
import com.ga.Todo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
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

    @PostMapping("/")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @GetMapping("/")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable Long id){
        return categoryService.getCategory(id);
    }

    @PutMapping("/update/{id}")
    public Category updateCategory(@PathVariable long id ,@RequestBody Category category){
        return categoryService.updateCategory(id,category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }

}
