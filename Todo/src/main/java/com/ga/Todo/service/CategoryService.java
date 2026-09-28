package com.ga.Todo.service;

import com.ga.Todo.exceptions.InformationExistException;
import com.ga.Todo.exceptions.InformationNotFoundException;
import com.ga.Todo.model.Category;
import com.ga.Todo.model.User;
import com.ga.Todo.repository.CategoryRepository;
import com.ga.Todo.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public static User getCurrentLoggedInUser(){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();

        return userDetails.getUser();
    }

    public Category createCategory(Category category){
        if (categoryRepository.findByUserIdAndName(getCurrentLoggedInUser().getId(), category.getName()) != null) {
            throw new InformationExistException(
                    "Category with name " + category.getName() + " already exists");
        }
        category.setUser(getCurrentLoggedInUser());
        return categoryRepository.save(category);
    }



    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public List<Category> getLoggedInUserCategories(){
        return categoryRepository.findByUserId(getCurrentLoggedInUser().getId());
    }

    public Optional<Category> getCategory(long id){
        return categoryRepository.findById(id);
    }

    public Category updateCategory(Long id,Category category){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()){
            if(getCurrentLoggedInUser().getId().equals(categoryOptional.get().getUser().getId())){
                Category existing = categoryOptional.get();
                existing.setName(category.getName());
                existing.setDescription(category.getDescription());
                return categoryRepository.save(existing);
            }else{
                throw new IllegalArgumentException("YOU cannot update a category u did not create");
            }

        }else{
            throw new InformationNotFoundException
                    ("Category with ID : "+ id + "is not found");
        }
    }

    public void deleteCategory(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        if(category.get().getUser().getId().equals(getCurrentLoggedInUser().getId())){
            categoryRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("U CANNOT DELETE A" +
                    " CATEGORY THAT YOU DID NOT CREATE");
        }    }
}
