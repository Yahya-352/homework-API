package com.ga.Todo.controller;

import com.ga.Todo.model.Item;
import com.ga.Todo.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;

    @PostMapping("/create")
    public Item createItem(@PathVariable Long categoryId ,@RequestBody Item item){
        return itemService.createItem(categoryId , item);
    }

    @GetMapping("/")
    public List<Item> getItems(){
        return itemService.getItems();
    }

    @GetMapping("/{categoryId}")
    public List<Item> getItemsByCategoryId(@PathVariable Long categoryId){
        return itemService.getItemsByCategoryId(categoryId);
    }

    @PutMapping("/update/{itemId}")
    public Item updateItem(@PathVariable Long itemId, @RequestBody Item item ){
        return itemService.updateItem(itemId , item);
    }

    @DeleteMapping("/delete/{itemId}")
    public void deleteItem(@PathVariable Long itemId){
        deleteItem(itemId);
    }
}
