package com.ga.Todo.service;

import com.ga.Todo.model.Category;
import com.ga.Todo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;



    public Category createCategory(Category category){
        Category category1 = categoryRepository.findByName(category.getName());
        return categoryRepository.save(category);
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategory(long id){
        return categoryRepository.findById(id);
    }
}
