package com.ga.Todo.service;

import com.ga.Todo.exceptions.InformationNotFoundException;
import com.ga.Todo.model.Category;
import com.ga.Todo.model.Item;
import com.ga.Todo.repository.CategoryRepository;
import com.ga.Todo.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ItemService {
    ItemRepository itemRepository;
    CategoryRepository categoryRepository;

    public Item createItem(Long categoryId,Item item){
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new InformationNotFoundException(
                        "Category Id " + categoryId + " not found")
        );
        item.setCategory(category);
        return itemRepository.save(item);
    }

    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    public List<Item> getItemsByCategoryId(Long categoryId){
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () ->new InformationNotFoundException("Category with ID : " + categoryId +
                        " Not Found")
        );

        return itemRepository.findByCategoryId(categoryId);
    }
    public Item updateItem(Long itemId , Item item){
        Item existing = itemRepository.findById(itemId).orElseThrow(
                () -> new InformationNotFoundException("Item with ID : " + itemId + " Not Found")
        );

        existing.setName(item.getName());
        existing.setDueDate(item.getDueDate());
        return itemRepository.save(existing);
    }

    public void deleteItem(Long itemId){
        itemRepository.deleteById(itemId);
    }

}
