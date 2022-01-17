package de.neuefische.backend.controller;

import de.neuefische.backend.models.ShoppingItem;
import de.neuefische.backend.service.ShoppingItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@CrossOrigin
public class ShoppingItemController {

    private final ShoppingItemService shoppingItemService;

    public ShoppingItemController(ShoppingItemService shoppingItemService){
        this.shoppingItemService = shoppingItemService;
    }

    @GetMapping("/")
    public List<ShoppingItem> getAllItems(){
        return shoppingItemService.getAllItems();
    }

    @GetMapping("/{itemId}")
    public ShoppingItem getItem(@PathVariable String itemId){
        return shoppingItemService.getItem(itemId);
    }

    @PostMapping("/")
    public ShoppingItem addNewItem(@RequestBody ShoppingItem newItem){
        return shoppingItemService.addNewItem(newItem);
    }

    @PutMapping("/")
    public ShoppingItem changeItemName(@RequestBody ShoppingItem newItem){
        return shoppingItemService.changeItemName(newItem);
    }

    @DeleteMapping("/{itemId}")
    public String deleteItem (@PathVariable String itemId){
        return shoppingItemService.deleteItem(itemId);
    }
}
