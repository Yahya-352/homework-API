package com.ga.Todo.repository;

import com.ga.Todo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long>{
    Item findByName(String name);
    List<Item> findByCategoryId(Long id);
}
