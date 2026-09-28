package com.ga.Todo.repository;

import com.ga.Todo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category , Long> {
    Category findByName(String name);

    Category findByUserIdAndName(Long userId , String categoryName);
    List<Category> findByUserId(Long userId);
}
