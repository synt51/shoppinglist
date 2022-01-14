package de.neuefische.backend.controller;

import de.neuefische.backend.models.ShoppingItem;
import de.neuefische.backend.service.ShoppingItemService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("items")
public class ShoppingItemController {

    private final ShoppingItemService shoppingItemService;

    public ShoppingItemController(ShoppingItemService shoppingItemService){
        this.shoppingItemService = shoppingItemService;
    }

    @GetMapping("all")
    public Collection<ShoppingItem> getAllItems(){
        return shoppingItemService.getAllItems();
    }

    @PutMapping("all")
    public String addNewItem(@RequestBody ShoppingItem newItem){
        return shoppingItemService.addNewItem(newItem);
    }
}
