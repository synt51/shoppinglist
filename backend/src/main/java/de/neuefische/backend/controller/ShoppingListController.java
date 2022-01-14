package de.neuefische.backend.controller;

import de.neuefische.backend.models.ShoppingList;
import de.neuefische.backend.service.ShoppingListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("lists")
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    public ShoppingListController(ShoppingListService shoppingListService){
        this.shoppingListService = shoppingListService;
    }

    @GetMapping("all")
    public Collection<ShoppingList> getAllLists(){
        return shoppingListService.getAllLists();
    }
}
